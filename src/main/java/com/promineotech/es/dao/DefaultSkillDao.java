package com.promineotech.es.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.promineotech.es.entity.Department;
import com.promineotech.es.entity.Skill;

@Component
public class DefaultSkillDao implements SkillDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

/*  public List<Skill> get(String skill_ID) {
    String sql = "SELECT skill_ID, description " + "From skill "+ "WHERE skill_ID = :skill_ID";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("skill_ID", skill_ID);
    List<Skill> skill = provider.query(sql, parameters, (rs, rowNum) -> {
      return new Skill(rs.getString("skill_ID"), rs.getString("description"));
      });
    if (skill.isEmpty()) {
      return Optional.empty();
    }//end IF
    return Optional.of(skill.get(0));
  }// end GET                               */
  
  @Override
  public List<Skill> get(String skill_ID) {
    String sql = 
        "SELECT skill_ID, description " 
        + "From skill "
        + "WHERE skill_ID = :skill_ID";
    Map<String, Object> params = new HashMap<>();
    params.put("skill_ID", skill_ID.toString());

    return jdbcTemplate.query(sql, new RowMapper<Skill>() {
      @Override
      public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Skill.builder()
            .skill_ID(rs.getInt("skill_ID"))
            .description(rs.getString("description"))
            .build();
        // @formatter:on
      }//end MAPROW
    });//end QUERY
  }// end LIST get  

  public List<Skill> delete(String skill_ID) {
    if ((skill_ID == null) || (skill_ID.isEmpty())) {
      return null;
    } // end IF

    List<Skill> existing = get(skill_ID);
    if (existing.isPresent()) {
// is this SQL correct??
      String sql = 
          "DELETE employee_skill.*, skill.* " 
          + "FROM employee_skill, skill "
          + "WHERE employee_skill.skill_ID = :skill_ID AND skill.skill_ID = :skill_ID;";

      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("skill_ID", skill_ID);

      int rows = jdbcTemplate.update(sql, parameters);
      if (rows > 0) {
        return existing;
      } // end IF 2
    } // end IF 1

    return null;
  }// end DELETE

}// end CLASS
