package com.promineotech.es.service;

import java.util.List;
import com.promineotech.es.entity.EmployeeSkill;


public interface EmployeeSkillService {
  
  List<EmployeeSkill> getEmployeeSkill(String employeeId);

}
