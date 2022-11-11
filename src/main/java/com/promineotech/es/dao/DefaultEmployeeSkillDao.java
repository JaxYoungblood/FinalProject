package com.promineotech.es.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.es.entity.EmployeeSkill;

@Component
public class DefaultEmployeeSkillDao implements EmployeeSkillDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

/*  public List<EmployeeSkill> get(String employee, String skill) {
    //@formatter:off
    String sql = "SELECT employee_ID, skill_ID " + "FROM employee_skill "+ "WHERE employee_ID = :employee_ID;";
    //@formatter:on
 MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("employee_ID", employee);
    List<EmployeeSkill> employeeSkill = provider.query(sql, parameters, (rs, rowNum) -> {
      return new EmployeeSkill(rs.getString("employee_ID"), rs.getInt("skill_ID"));
    });
    if (employeeSkill.isEmpty()) {
      return Optional.empty();
    } // end IF
    return Optional.of(employeeSkill.get(0));
  }// end GET                                       */
  
  @Override
  public List<EmployeeSkill> get(String employee, String skill) {
    String sql = "SELECT employee_ID, skill_ID " 
        + "FROM employee_skill "
        + "WHERE employee_ID = :employee_ID;";
    Map<String, Object> params = new HashMap<>();
    params.put("employee_ID", employee.toString());

    return jdbcTemplate.query(sql, new RowMapper<EmployeeSkill>() {
      @Override
      public EmployeeSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return EmployeeSkill.builder()
            .employee_ID(rs.getString("employee_ID"))
            .skill_ID(rs.getInt("skill_ID"))
            .build();
        // @formatter:on
      }//end MAPROW
    });//end QUERY
  }// end LIST get
  
}// end CLASS
