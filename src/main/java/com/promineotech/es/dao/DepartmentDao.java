package com.promineotech.es.dao;

import java.util.Optional;
import com.promineotech.es.entity.Department;

public interface DepartmentDao {


  Optional<Department> createDepartment(String departmentId, String description);
  
  Optional<Department> deleteDepartment(String departmentId);

}
