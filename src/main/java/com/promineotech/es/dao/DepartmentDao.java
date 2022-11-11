package com.promineotech.es.dao;

import java.util.List;
//import java.util.Optional;
import com.promineotech.es.entity.Department;

public interface DepartmentDao {

  List<Department> get(String department_ID);

  List<Department> delete(String department_ID);

}
