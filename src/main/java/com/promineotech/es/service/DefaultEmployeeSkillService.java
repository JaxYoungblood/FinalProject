package com.promineotech.es.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.es.dao.EmployeeSkillDao;
import com.promineotech.es.entity.EmployeeSkill;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEmployeeSkillService implements EmployeeSkillService {
  
  @Autowired
  private EmployeeSkillDao employeeSkillDoa;
  

  @Transactional(readOnly = true)
  @Override
  public List<EmployeeSkill> getEmployeeSkill(String employeeId, int skillId) {
    log.info("The getEmployeeSkill method was called with employeeId={} and skillId={}", employeeId, skillId);
    
    return employeeSkillDoa.getEmployeeSkill(employeeId, skillId);
  }

}
