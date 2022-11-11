package com.promineotech.es.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.es.dao.EmployeeDao;
import com.promineotech.es.entity.Employee;
import com.promineotech.es.entity.InputEmployee;


@Service
public class DefaultEmployeeService implements EmployeeService {
  private EmployeeDao employeeDao;

  // @Override (Error occurred below requesting me to remove OVERRIDE)
  public Employee getEmployee(String employee_ID) {
    if ((employee_ID == null) || (employee_ID.isEmpty())) {
      return null;
    } // end IF 1
    List<Employee> employee = employeeDao.get(employee_ID);
    if (employee.isEmpty()) {
      return null;
    } // end IF 2
    return employee.get(0);
  }// end getEmployee


  // @Override (Error occurred below requesting me to remove OVERRIDE)
  public Employee createEmployee(InputEmployee input) {
    if ((input != null) && (input.isValid())) {
      List<Employee> result = employeeDao.create(input);
      if (result.isPresent()) {
        return result.get(0);
      } // end IF 2
    } // end IF 1
    return null;
  }// end createEmployee


  // @Override (Error occurred below requesting me to remove OVERRIDE)
  public Employee updateEmployee(InputEmployee input) {
    if ((input != null) && (input.isValid())) {
      List<Employee> result = employeeDao.update(input);
      if (result.isPresent()) {
        return result.get(0);
      } // end IF 2
    } // end IF 1
    return null;
  }// end updateEmployee


  // @Override (Error occurred below requesting me to remove OVERRIDE)
  public Employee deleteEmployee(String employee_ID) {
    if ((employee_ID == null) || (employee_ID.isEmpty())) {
      return null;
    } // end IF 1
    List<Employee> deleted = employeeDao.delete(employee_ID);
    if (deleted.isPresent()) {
      return deleted.get(0);
    } // end IF 2
    return null;
  }// end deleteEmployee


}// end CLASS

