package com.promineotech.es.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.es.dao.DepartmentDao;
import com.promineotech.es.entity.Department;

@Service
public class DefaultDepartmentService implements DepartmentService {
  private DepartmentDao departmentDao;


  public Department getDepartment(String department_ID) {
    if ((department_ID == null) || (department_ID.isEmpty())) {
      return null;
    } // end IF 1
    List<Department> Department = departmentDao.get(department_ID);
    if (Department.isEmpty()) {
      return null;
    } // end IF 2
    return Department.get(0);
  }// end GET


  public Department deleteDepartment(String department_ID) {
    if ((department_ID == null) || (department_ID.isEmpty())) {
      return null;
    } // end IF 1
    List<Department> deleted = departmentDao.delete(department_ID);
    if (deleted.isPresent()) {
      return deleted.get(0);
    } // end IF 2
    return null;
  }// end DELETE

}// end CLASS
