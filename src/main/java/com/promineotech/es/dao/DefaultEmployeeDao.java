package com.promineotech.es.dao;

import java.math.BigDecimal;
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
import com.promineotech.es.entity.Employee;
import com.promineotech.es.entity.InputEmployee;


@Component
public class DefaultEmployeeDao implements EmployeeDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

/*  public Optional<Employee> get(String employee_ID) {
    String sql = "SELECT employee_ID, department_ID, first_name, last_name, phone " + "FROM employee "+ "WHERE employee_ID = :employee_ID;";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("employee_ID", employee_ID);
    List<Employee> employee = provider.query(sql, parameters, (rs, rowNum) -> {
      return new Employee(rs.getString("employee_ID"), rs.getString("department_ID"), rs.getString("first_name"),rs.getString("last_name"), rs.getString("phone"));
    });
    if (employee.isEmpty()) {
      return Optional.empty();
    } // end IF
    return Optional.of(employee.get(0));
  }// end GET                               */

  @Override
  public List<Employee> get(String employee_ID) {
        String sql = "SELECT employee_ID, department_ID, first_name, last_name, phone " 
            + "FROM employee "
            + "WHERE employee_ID = :employee_ID;";
    Map<String, Object> params = new HashMap<>();
    params.put("employee_ID", employee_ID.toString());

    return jdbcTemplate.query(sql, new RowMapper<Employee>() {
      @Override
      public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Employee.builder()
            .employee_ID(new String(rs.getString("employee_ID")))
            .department_ID(new String(rs.getString("department_ID")))
            .first_name(new String(rs.getString("first_name")))
            .last_name(new String(rs.getString("last_name")))
            .phone(new String(rs.getString("phone")))
            .build();
        // @formatter:on
      }//end MAPROW
    });//end QUERY
  }// end LIST get
 
  
  public List<Employee> create(InputEmployee input) {
    if ((input == null) || (!input.isValid())) {
      return null;
    } // end IF
    String sql = "INSERT INTO customers (customer_pk, first_name, last_name, phone) "
        + "Values (:customer_pk, :first_name, :last_name, :phone);";

    MapSqlParameterSource parameters = new MapSqlParameterSource();
    String department_ID = input.getDepartmentID();
    String first_name = input.getFirstName();
    String last_name = input.getLastName();
    String phone = input.getPhoneNumber();
//How do I get just first name initial??
    String employee_ID = last_name + "_" + first_name;
    parameters.addValue("employee_ID", employee_ID);
    parameters.addValue("department_ID", department_ID);
    parameters.addValue("first_name", first_name);
    parameters.addValue("last_name", last_name);
    parameters.addValue("phone", phone);

    int rows = jdbcTemplate.update(sql, parameters);
    if (rows > 0) {
      return get(employee_ID);
    } // end IF
    return null;
  }// end CREATE


  // @Override (Error occurred below requesting me to remove OVERRIDE)
  public List<Employee> update(InputEmployee input) {
    if ((input == null) || (!input.isValid())) {
      return null;
    }
    String sql = "UPDATE employee SET phone = :phone WHERE employee_ID = :employee_ID; ";

    MapSqlParameterSource parameters = new MapSqlParameterSource();
    String department_ID = input.getDepartmentID();
    String first_name = input.getFirstName();
    String last_name = input.getLastName();
    String phone = input.getPhoneNumber();
    String employee_ID = last_name + "_" + first_name;
    parameters.addValue("phone", phone);
    parameters.addValue("employee_ID", employee_ID);
    parameters.addValue("department_ID", department_ID);
    parameters.addValue("first_name", first_name);
    parameters.addValue("last_name", last_name);

    int rows = jdbcTemplate.update(sql, parameters);
    if (rows > 0) {
      return get(employee_ID);
    } // end IF
    return null;
  }// end UPDATE


  // @Override (Error occurred below requesting me to remove OVERRIDE)
  public List<Employee> delete(String employee_ID) {
    if ((employee_ID == null) || (employee_ID.isEmpty())) {
      return null;
    } // end IF

    List<Employee> existing = get(employee_ID);
    if (existing.isPresent()) {
      String sql = 
          "DELETE FROM employee WHERE employee_ID = :employee_ID";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("employee_ID", employee_ID);

      int rows = jdbcTemplate.update(sql, parameters);
      if (rows > 0) {
        return existing;
      } // end IF 2
    } // end IF 1
    return null;
  }// end DELETE

}// end CLASS

