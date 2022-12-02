package com.promineotech.es.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.es.dao.DepartmentDao;
import com.promineotech.es.entity.Department;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultDepartmentService implements DepartmentService {
  
  @Autowired
  private DepartmentDao departmentDao;

  
//CREATE
    @Override
    public Optional<Department> createDepartment(String departmentId, String description) {
      log.info("The createDepartment method was called with departmentId={}, description={}", departmentId, description); 
  
      return departmentDao.createDepartment(departmentId, description); 
    }
  
  
//DELETE
  @Override
  public Optional<Department> deleteDepartment(String departmentId) {
    return departmentDao.deleteDepartment(departmentId); 
  }

}
