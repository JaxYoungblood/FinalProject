package com.promineotech.es.service;

import java.util.Optional;
import com.promineotech.es.entity.Department;


public interface DepartmentService {

  Optional<Department> createDepartment(String departmentId, String description);
  
  Optional<Department> deleteDepartment(String departmentId);


}
