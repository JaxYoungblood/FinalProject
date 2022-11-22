package com.promineotech.es.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.es.dao.EmployeeDao;
import com.promineotech.es.entity.Employee;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultEmployeeService implements EmployeeService {
  @Autowired
  private EmployeeDao employeeDao;


//READ
  @Transactional(readOnly = true)
  @Override
  public List<Employee> getEmployee(String employeeId) {
    log.info("The getEmployee method was called with employeeId={}", employeeId);

    return employeeDao.getEmployee(employeeId);
  }


//CREATE
  @Override
  public Optional<Employee> createEmployee(String employeeId, String departmentId, String firstName, String lastName, String phone) {
    log.info("The createEmployee method was called with employeeId={}, departmentId={}, firstName={}, lastName={}, phone={}", employeeId, departmentId, firstName, lastName, phone); 

    return employeeDao.createEmployee(employeeId, departmentId, firstName, lastName, phone);
  }


//UPDATE
  @Override
  public Optional<Employee> updateEmployee(String employeeId,String departmentId, String firstName, String lastName, String phone, String newDepartmentId, String newFirstName, String newLastName, String newPhone) {
    log.info("The updateEmployee method was called with "
        + "employeeId={}, departmentId={}, firstName={}, lastName={}, phone={}, " 
        + "newDepartmentId={}, newFirstName={}, newLastName={}, newPhone={}", employeeId, departmentId, firstName, lastName, phone, newDepartmentId, newFirstName, newLastName, newPhone); 

    return employeeDao.updateEmployee(employeeId, departmentId, firstName, lastName, phone, newDepartmentId, newFirstName, newLastName, newPhone);
  }


//DELETE
  @Override
  public Optional<Employee> deleteEmployee(String employeeId) {

    return employeeDao.deleteEmployee(employeeId);
  }


}

