package com.promineotech.es.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.es.dao.DepartmentDao;
import com.promineotech.es.entity.Department;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultDepartmentService implements DepartmentService {
  
  @Autowired
  private DepartmentDao departmentDao;

//READ
  @Transactional(readOnly = true)
  @Override
  public  List<Department> getDepartment(String departmentId){
    log.info("The getDepartment method was called with department_ID={}",
        departmentId);
    
    return departmentDao.getDepartment(departmentId);
  }
  
  
//DELETE
  @Override
  public Optional<Department> deleteDepartment(String departmentId) {
    return departmentDao.deleteDepartment(departmentId); 
  }

}
