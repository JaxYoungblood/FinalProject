package com.promineotech.es.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.es.entity.Department;

public interface DepartmentDao {

  List<Department> getDepartment(String departmentId);

  Optional<Department> deleteDepartment(String departmentId);

}
