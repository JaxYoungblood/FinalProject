package com.promineotech.es.dao;

import java.util.Optional;
import com.promineotech.es.entity.Employee;
import com.promineotech.es.entity.InputEmployee;

public interface EmployeeDao {
  Optional<Employee> get(String employee_ID);

  Optional<Employee> create(InputEmployee input);

  Optional<Employee> update(InputEmployee input);

  Optional<Employee> delete(String employee_ID);

}// end INTERFACE
