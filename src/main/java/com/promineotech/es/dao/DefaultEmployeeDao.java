package com.promineotech.es.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.es.entity.Employee;
import com.promineotech.es.entity.InputEmployee;

@Repository
public class DefaultEmployeeDao implements EmployeeDao {
  private NamedParameterJdbcTemplate provider;

  public DefaultEmployeeDao(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
  }


  public Optional<Employee> get(String employee_ID) {
    String sql = "SELECT employee_ID, department_ID, first_name, last_name, phone " 
        + "FROM employee "
        + "WHERE employee_ID = :employee_ID;";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("employee_ID", employee_ID);

    List<Employee> employee = provider.query(sql, parameters, (rs, rowNum) -> {
      // @Formatter:off
      return new Employee(
          rs.getString("employee_ID"), 
          rs.getString("department_ID"), 
          rs.getString("first_name"),
          rs.getString("last_name"), 
          rs.getString("phone"));
    });// @Formatter:on
    if (employee.isEmpty()) {
      return Optional.empty();
    } // end IF
    return Optional.of(employee.get(0));
  }// end GET


  public Optional<Employee> create(InputEmployee input) {
    if ((input == null) || (!input.isValid())) {
      return Optional.empty();
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

    int rows = provider.update(sql, parameters);
    if (rows > 0) {
      return get(employee_ID);
    } // end IF
    return Optional.empty();
  }// end CREATE


  // @Override (Error occurred below requesting me to remove OVERRIDE)
  public Optional<Employee> update(InputEmployee input) {
    if ((input == null) || (!input.isValid())) {
      return Optional.empty();
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

    int rows = provider.update(sql, parameters);
    if (rows > 0) {
      return get(employee_ID);
    } // end IF
    return Optional.empty();
  }// end UPDATE


  // @Override (Error occurred below requesting me to remove OVERRIDE)
  public Optional<Employee> delete(String employee_ID) {
    if ((employee_ID == null) || (employee_ID.isEmpty())) {
      return Optional.empty();
    } // end IF

    Optional<Employee> existing = get(employee_ID);
    if (existing.isPresent()) {
      String sql = 
          "DELETE FROM employee WHERE employee_ID = :employee_ID";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("employee_ID", employee_ID);

      int rows = provider.update(sql, parameters);
      if (rows > 0) {
        return existing;
      } // end IF 2
    } // end IF 1

    return Optional.empty();
  }// end DELETE

}// end CLASS

