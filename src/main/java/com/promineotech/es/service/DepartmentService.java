package com.promineotech.es.service;

import com.promineotech.es.entity.Department;

public interface DepartmentService {

  Department getDepartment(String department_ID);

  Department deleteDepartment(String department_ID);

}
