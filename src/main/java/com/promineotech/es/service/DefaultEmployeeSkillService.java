package com.promineotech.es.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.promineotech.es.dao.EmployeeSkillDao;
import com.promineotech.es.entity.EmployeeSkill;

@Service
public class DefaultEmployeeSkillService implements EmployeeSkillService {
  private EmployeeSkillDao employeeSkillDoa;
  

  public EmployeeSkill getEmployeeSkill(String employee, String skill) {
    if ((employee == null) || (employee.isEmpty())) {
      return null;
    } // end IF 1
    List<EmployeeSkill> employeeSkill = employeeSkillDoa.get(employee, skill);
    if (employeeSkill.isEmpty()) {
      return null;
    } // end IF 2
    return employeeSkill.get(0);
  }// end GET

}// end CLASS
