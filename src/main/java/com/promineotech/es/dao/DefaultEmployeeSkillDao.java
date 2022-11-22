package com.promineotech.es.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.es.entity.EmployeeSkill;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultEmployeeSkillDao implements EmployeeSkillDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  
//READ
  @Override
  public List<EmployeeSkill> getEmployeeSkill(String employeeId, int skillId) {
    log.info("DAO: employeeId={}, skillId={}", employeeId, skillId);
    
    String sql = ""
        + "SELECT employee_ID, skill_ID " 
        + "FROM employee_skill "
        + "WHERE employee_ID = :employee_ID;";
    Map<String, Object> params = new HashMap<>();
    params.put("employee_ID", employeeId);
    params.put("skill_ID", skillId);

    return jdbcTemplate.query(sql, new RowMapper<EmployeeSkill>() {
      
      @Override
      public EmployeeSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return EmployeeSkill.builder()
            .employeeId(rs.getString("employee_ID"))
            .skillId(rs.getInt("skill_ID"))
            .build();
        // @formatter:on
      }});
  }
  
}
