package com.promineotech.es.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.es.dao.DepartmentDao;
import com.promineotech.es.entity.Department;

@Service
public class DefaultDepartmentService implements DepartmentService {
  private DepartmentDao repository;

  public DefaultDepartmentService(DepartmentDao repository) {
    this.repository = repository;
  }


  public Department getDepartment(String department_ID) {
    if ((department_ID == null) || (department_ID.isEmpty())) {
      return null;
    } // end IF 1
    Optional<Department> Department = repository.get(department_ID);
    if (Department.isEmpty()) {
      return null;
    } // end IF 2
    return Department.get();
  }// end GET


  public Department deleteDepartment(String department_ID) {
    if ((department_ID == null) || (department_ID.isEmpty())) {
      return null;
    } // end IF 1
    Optional<Department> deleted = repository.delete(department_ID);
    if (deleted.isPresent()) {
      return deleted.get();
    } // end IF 2
    return null;
  }// end DELETE

}// end CLASS
