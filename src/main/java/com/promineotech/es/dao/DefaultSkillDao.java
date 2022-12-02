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

  
//CREATE
  @Override
  public Optional<Skill> createSkill(int skillId, String description) {
    log.info("DAO: skill_ID={}, description={}", skillId, description);
        //@formatter:off
    String sql = ""
        + "INSERT INTO skill "
        + "(skill_ID, description"
        + ") VALUES ("
        + ":skill_ID, :description);";
        //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("skill_ID", skillId);
    params.put("description", description); 

    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Skill
        .builder()
        .skillId(skillId)
        .description(description)
        .build());
  }

  
//DELETE
  @Override
  public Optional<Skill> deleteSkill(int skillId) {
      String sql = ""
          + "DELETE FROM skill "
          + "WHERE skill_ID = :skill_ID;";

      Map<String, Object> params = new HashMap<>();
      params.put("skill_ID", skillId);

      jdbcTemplate.update(sql, params); 

      return Optional.ofNullable(Skill.builder()
          .skillId(skillId)
          .build());
      }
  
  }

