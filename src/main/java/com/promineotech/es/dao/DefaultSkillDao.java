package com.promineotech.es.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.es.entity.Skill;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultSkillDao implements SkillDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  
//READ
  @Override
  public List<Skill> getSkill(int skillId) {
    log.info("DAO: skillId={}", skillId);

    String sql = ""
        + "SELECT * " 
        + "From skill "
        + "WHERE skill_ID = :skill_ID";
    
    Map<String, Object> params = new HashMap<>();
    params.put("skill_ID", skillId);

    return jdbcTemplate.query(sql, params, new RowMapper<Skill>() {
      
      @Override
      public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Skill.builder()
            .skillId(rs.getInt("skill_ID"))
            .description(rs.getString("description"))
            .build();
        // @formatter:on
      }});
  } 

  
//DELETE
  @Override
  public Optional<Skill> deleteSkill(int skillId) {
      String sql = ""
          + "DELETE employee_skill.*, skill.* " 
          + "FROM employee_skill, skill "
          + "WHERE employee_skill.skill_ID = :skill_ID AND skill.skill_ID = :skill_ID;";

      Map<String, Object> params = new HashMap<>();
      params.put("skill_ID", skillId);

      jdbcTemplate.update(sql, params); 

      return Optional.ofNullable(Skill.builder()
          .skillId(skillId)
          .build());
      }
  
  }

