package com.promineotech.es.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.es.entity.Department;

public interface DepartmentService {

  List<Department> getDepartment(String departmentId);

  Optional<Department> deleteDepartment(String departmentId);

}
