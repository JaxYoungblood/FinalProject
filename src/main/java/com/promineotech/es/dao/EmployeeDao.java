package com.promineotech.es.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.es.entity.Employee;

public interface EmployeeDao {
  
  List<Employee> getEmployee(String employeeId);

  Optional<Employee> createEmployee(String employeeId, String departmentId, String firstName, String lastName, String phone);

  Optional<Employee> updateEmployee(String employeeId, String departmentId, String firstName, String lastName, String phone, String newDepartmentId, String newFirstName, String newLastName, String newPhone);

  Optional<Employee> deleteEmployee(String employeeId);

}
