package com.promineotech.es.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.promineotech.es.entity.Skill;

@Repository
public class DefaultSkillDao implements SkillDao {
  private NamedParameterJdbcTemplate provider;

  public DefaultSkillDao(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
  }


  public Optional<Skill> get(String skill_ID) {
    String sql = "SELECT skill_ID, description " 
        + "From skill "
        + "WHERE skill_ID = :skill_ID";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("skill_ID", skill_ID);

    List<Skill> skill = provider.query(sql, parameters, (rs, rowNum) -> {
      return new Skill(rs.getString("skill_ID"), 
          rs.getString("description");
      });
    if (skill.isEmpty()) {
      return Optional.empty();
    }//end IF
    return Optional.of(skill.get(0));
  }// end GET


  public Optional<Skill> delete(String skill_ID) {
    if ((skill_ID == null) || (skill_ID.isEmpty())) {
      return Optional.empty();
    } // end IF

    Optional<Skill> existing = get(skill_ID);
    if (existing.isPresent()) {
      // is this SQL correct??
      String sql = "DELETE employee_skill.*, skill.* " + "FROM employee_skill, skill "
          + "WHERE employee_skill.skill_ID = :skill_ID AND skill.skill_ID = :skill_ID;";

      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("skill_ID", skill_ID);

      int rows = provider.update(sql, parameters);
      if (rows > 0) {
        return existing;
      } // end IF 2
    } // end IF 1

    return Optional.empty();
  }// end DELETE


  private Optional<Skill> getID(String skill_ID) {
    return null;
  }// end GET

}// end CLASS
