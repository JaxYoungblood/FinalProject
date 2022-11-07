package com.promineotech.es.service;

import com.promineotech.es.entity.Employee;
import com.promineotech.es.entity.InputEmployee;


public interface EmployeeService {
  Employee getEmployee(String id);

  Employee createEmployee(InputEmployee input);

  Employee updateEmployee(InputEmployee input);

  Employee deleteEmployee(String id);

}// end CLASS
