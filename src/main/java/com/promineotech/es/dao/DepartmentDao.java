package com.promineotech.es.dao;

import java.util.Optional;
import com.promineotech.es.entity.Department;

public interface DepartmentDao {

  Optional<Department> get(String department_ID);

  Optional<Department> delete(String department_ID);

}
