package com.promineotech.es.dao;

import java.util.List;
//import java.util.Optional;
import com.promineotech.es.entity.Employee;
import com.promineotech.es.entity.InputEmployee;

public interface EmployeeDao {
  List<Employee> get(String employee_ID);

  List<Employee> create(InputEmployee input);

  List<Employee> update(InputEmployee input);

  List<Employee> delete(String employee_ID);

}// end INTERFACE
