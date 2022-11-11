package com.promineotech.es.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.es.entity.Department;
import com.promineotech.es.entity.Employee;
import com.promineotech.es.entity.Skill;

@Component
public class DefaultDepartmentDao implements DepartmentDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

/*  public Optional<Department> get(String department_ID) {
    String sql = "SELECT department_ID, description " + "From department " + "WHERE department_ID = :department_ID";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("department_ID", department_ID);
    List<Department> department = provider.query(sql, parameters, (rs, rowNum) -> {
      return new Department(rs.getString("department_ID"), rs.getString("description"); 
      });
    if (department.isEmpty()) {
      return Optional.empty();
    }//end IF
    return Optional.of(department.get(0));
  }// end GET                                   */

  @Override
  public List<Department> get(String department_ID) {
    String sql = "SELECT department_ID, description " 
        + "From department "
        + "WHERE department_ID = :department_ID";
    Map<String, Object> params = new HashMap<>();
    params.put("department_ID", department_ID.toString());

    return jdbcTemplate.query(sql, new RowMapper<Department>() {
      @Override
      public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Department.builder()
            .department_ID(new String(rs.getString("department_ID")))
            .description(new String(rs.getString("description")))
            .build();
        // @formatter:on
      }//end MAPROW
    });//end QUERY
  }// end LIST get

  public List<Department> delete(String department_ID) {
    if ((department_ID == null) || (department_ID.isEmpty())) {
      return new LinkedList<>();
    } // end IF

    List<Department> existing = get(department_ID);
    if (existing.isPresent()) {
// is this SQL correct??
      String sql = "DELETE employee.*, department.* " + "FROM employee, department "
          + "WHERE employee.department_ID = :department_ID AND department.department_ID = :department_ID;";

      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("department_ID", department_ID);

      int rows = jdbcTemplate.update(sql, parameters);
      if (rows > 0) {
        return existing;
      } // end IF 2
    } // end IF 1

    return null;
  }// end DELETE


}// end CLASS
