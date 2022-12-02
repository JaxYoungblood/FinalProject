package com.promineotech.es.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.es.entity.Department;
import com.promineotech.es.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultDepartmentController implements DepartmentController {
  
  @Autowired
  private DepartmentService service;

  
//CREATE
  @Override
  public Optional<Department> createDepartment(String departmentId, String description) {
    log.info("departmentId={}, description={}", departmentId, description); 
    
    return service.createDepartment(departmentId, description); 
  }
  

  //DELETE
  @Override
  public Optional<Department> deleteDepartment(String departmentId) {
    log.info("department_ID={}", departmentId);
   
    return service.deleteDepartment(departmentId); 
  }

}
