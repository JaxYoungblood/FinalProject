package com.promineotech.es.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.es.entity.EmployeeSkill;

@Repository
public class DefaultEmployeeSkillDao implements EmployeeSkillDao {
  private NamedParameterJdbcTemplate provider;

  public DefaultEmployeeSkillDao(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
  }


  public Optional<EmployeeSkill> get(String employee, String skill) {
    //@formatter:off
    String sql = "SELECT employee_ID, skill_ID " 
               + "FROM employee_skill "
               + "WHERE employee_ID = :employee_ID;";
    //@formatter:on
 MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("employee_ID", employee);

    List<EmployeeSkill> employeeSkill = provider.query(sql, parameters, (rs, rowNum) -> {
      return new EmployeeSkill(
          rs.getString("employee_ID"), 
          rs.getString("skill_ID"));
    });
    if (employeeSkill.isEmpty()) {
      return Optional.empty();
    } // end IF

    return Optional.of(employeeSkill.get(0));
  }// end GET

}// end CLASS
