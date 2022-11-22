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
import com.promineotech.es.entity.Department;

@Component
public class DefaultDepartmentDao implements DepartmentDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
//READ
  @Override     
  public List<Department> getDepartment(String departmentId) {
    String sql = ""
        + "SELECT * " 
        + "From department "
        + "WHERE department_ID = :department_ID";
    Map<String, Object> params = new HashMap<>();
    params.put("department_ID", departmentId.toString());

    return jdbcTemplate.query(sql, new RowMapper<>() {
      @Override
      public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Department.builder()
            .departmentId(new String(rs.getString("department_ID")))
            .description(new String(rs.getString("description")))
            .build();   // @formatter:on
      }
    });
  }

  
//DELETE
  @Override     
  public Optional<Department> deleteDepartment(String departmentId) {
    // is this SQL correct????????????????????????????????????????????????????????????
      String sql = ""
          + "DELETE employee.*, department.* " 
          + "FROM employee, department "
          + "WHERE employee.department_ID = :department_ID AND department.department_ID = :department_ID;";

      Map<String, Object> params = new HashMap<>();
      params.put("department_ID", departmentId);
      
      jdbcTemplate.update(sql, params);
      
      return Optional.ofNullable(Department
          .builder()
          .departmentId(departmentId)
          .build());  
      }


}// end CLASS
