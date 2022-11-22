package com.promineotech.es.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.es.entity.Employee;
import com.promineotech.es.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultEmployeeController implements EmployeeController {

  @Autowired
  private EmployeeService service;



  // READ
  @Override
  public List<Employee> getEmployee(String employeeId) {
    log.info("employee_ID={}", employeeId);

    return service.getEmployee(employeeId);
  }


  // CREATE
  @Override
  public Optional<Employee> createEmployee(String employeeId, String departmentId, String firstName, String lastName, String phone) {
    log.info("employee_ID={}, department_ID={}, first_name={}, last_name={}, phone={}", employeeId, departmentId, firstName, lastName, phone);

    return service.createEmployee(employeeId, departmentId, firstName, lastName, phone);
  }


  // UPDATE
  @Override
  public Optional<Employee> updateEmployee(String employeeId, String departmentId, String firstName, String lastName, String phone, String newDepartmentId, String newFirstName, String newLastName, String newPhone) {
    log.info("The updateEmployee method was called with "
        + "employeeId={}, departmentId={}, firstName={}, lastName={}, phone={}, " 
        + "newDepartmentId={}, newFirstName={}, newLastName={}, newPhone={}", employeeId, departmentId, firstName, lastName, phone, newDepartmentId, newFirstName, newLastName, newPhone);

    return service.updateEmployee(employeeId, departmentId, firstName, lastName, phone, newDepartmentId, newFirstName, newLastName, newPhone);
  }


  // DELETE
  @Override
  public Optional<Employee> deleteEmployee(String employeeId) {
    log.info("employee_ID={}", employeeId);

    return service.deleteEmployee(employeeId);
  }


}
