package com.promineotech.es.service;

import com.promineotech.es.entity.Employee;
import com.promineotech.es.entity.InputEmployee;


public interface EmployeeService {
  
  Employee getEmployee(String employee_ID);

  Employee createEmployee(InputEmployee input);

  Employee updateEmployee(InputEmployee input);

  Employee deleteEmployee(String employee_ID);

}// end CLASS
