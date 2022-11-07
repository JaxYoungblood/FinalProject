package com.promineotech.es.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.es.entity.Department;
import com.promineotech.es.entity.Skill;

@Repository
public class DefaultDepartmentDao implements DepartmentDao {
  private NamedParameterJdbcTemplate provider;

  public DefaultDepartmentDao(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
  }


  public Optional<Department> get(String department_ID) {
    String sql = "SELECT department_ID, description " 
        + "From department "
        + "WHERE department_ID = :department_ID";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("department_ID", department_ID);

    List<Department> department = provider.query(sql, parameters, (rs, rowNum) -> {
      return new Department(rs.getString("department_ID"), 
          rs.getString("description");
      });
    if (department.isEmpty()) {
      return Optional.empty();
    }//end IF
    return Optional.of(department.get(0));
  }// end GET


  public Optional<Department> delete(String department_ID) {
    if ((department_ID == null) || (department_ID.isEmpty())) {
      return Optional.empty();
    } // end IF

    Optional<Department> existing = get(department_ID);
    if (existing.isPresent()) {
      // is this SQL correct??
      String sql = "DELETE employee.*, department.* " + "FROM employee, department "
          + "WHERE employee.department_ID = :department_ID AND department.department_ID = :department_ID;";

      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("department_ID", department_ID);

      int rows = provider.update(sql, parameters);
      if (rows > 0) {
        return existing;
      } // end IF 2
    } // end IF 1

    return Optional.empty();
  }// end DELETE


  private Optional<Department> getID(Department department_ID) {
    return null;
  }// end GET

}// end CLASS
