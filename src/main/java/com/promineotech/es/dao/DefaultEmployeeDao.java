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
import com.promineotech.es.entity.Employee;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DefaultEmployeeDao implements EmployeeDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  
//READ
  @Override
  public List<Employee> getEmployee(String employeeId) {
    log.info("DAO: employee_ID={}", employeeId);
            //@formatter:off
        String sql = ""
            + "SELECT employee_ID, department_ID, first_name, last_name, phone " 
            + "FROM employee "
            + "WHERE employee_ID = :employee_ID;";
            //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("employee_ID", employeeId);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
        return Employee.builder()
            .employeeId(new String(rs.getString("employee_ID")))
            .departmentId(new String(rs.getString("department_ID")))
            .firstName(new String(rs.getString("first_name")))
            .lastName(new String(rs.getString("last_name")))
            .phone(new String(rs.getString("phone")))
            .build();
            // @formatter:on
      }});
  }
 
  
//CREATE
  @Override
  public Optional<Employee> createEmployee(String employeeId, String departmentId, String firstName, String lastName, String phone) {
    log.info("DAO: employee_ID={}, departmentId={}, firstName={}, lastName={}, phone={}", employeeId, departmentId, firstName, lastName, phone);
        //@formatter:off
    String sql = ""
        + "INSERT INTO employee "
        + "(employee_ID, department_ID, first_name, last_name, phone"
        + ") VALUES ("
        + ":employee_ID, :department_ID, :first_name, :last_name, :phone);";
        //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("employee_ID", employeeId);
    params.put("department_ID", departmentId);
    params.put("first_name", firstName); 
    params.put("last_name", lastName); 
    params.put("phone", phone); 

    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Employee
        .builder()
        .employeeId(employeeId)
        .departmentId(departmentId)
        .firstName(firstName)
        .lastName(lastName)
        .phone(phone)
        .build());
  }

  
//UPDATE
  @Override
  public Optional<Employee> updateEmployee(
      String employeeId, String departmentId, String firstName, String lastName, String phone, 
      String newDepartmentId, String newFirstName, String newLastName, String newPhone) {
    
    log.info("DAO: employee_ID={}, departmentId={}, firstName={}, lastName={}, phone={}, "
        + "newDepartmentId={}, newFirstName={}, newLastName={}, newPhone={}", 
          employeeId, departmentId, firstName, lastName, phone, newDepartmentId, newFirstName, newLastName, newPhone);
        //@formatter:off
    
    String sql = ""
        + "UPDATE employee SET phone = :new_phone, "
        + "first_name = :new_first_name, "
        + "last_name = :new_last_name, "
        + "department_ID = :new_department_ID "
        + "WHERE employee_ID = :employee_ID AND "
        + "first_name = :first_name AND "
        + "last_name = :last_name";
        //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("employee_ID", employeeId);
    params.put("department_ID", departmentId);
    params.put("first_name", firstName); 
    params.put("last_name", lastName); 
    params.put("phone", phone);  
    params.put("new_department_ID", newDepartmentId);
    params.put("new_first_name", newFirstName); 
    params.put("new_last_name", newLastName); 
    params.put("new_phone", newPhone);  
    
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Employee
        .builder()
        .employeeId(employeeId)
        .departmentId(newDepartmentId)
        .firstName(newFirstName)
        .lastName(newLastName)
        .phone(newPhone)
        .build());
  }


//DELETE
  @Override
  public Optional<Employee> deleteEmployee(String employeeId) {
          //@formatter:off
      String sql = ""
          + "DELETE FROM employee "
          + "WHERE employee_ID = :employee_ID";
          //@formatter:on

      Map<String, Object> params = new HashMap<>();
      params.put("employee_ID", employeeId);

      jdbcTemplate.update(sql, params);

      return Optional.ofNullable(Employee
          .builder()
          .employeeId(employeeId)
          .build());
      }

}

