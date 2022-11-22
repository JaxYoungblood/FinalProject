package com.promineotech.es.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.es.entity.EmployeeSkill;
import com.promineotech.es.service.EmployeeSkillService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultEmployeeSkillController {
  @Autowired
  private EmployeeSkillService service;
  
  
//READ
  //@Override
  public List<EmployeeSkill> getEmployeeSkill(String employeeId, int skillId) {
    log.info("employeeId={}", employeeId); 
    
    return service.getEmployeeSkill(employeeId, skillId); 
  }

}
