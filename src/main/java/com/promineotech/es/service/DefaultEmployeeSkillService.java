package com.promineotech.es.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.es.dao.EmployeeSkillDao;
import com.promineotech.es.entity.EmployeeSkill;

@Service
public class DefaultEmployeeSkillService implements EmployeeSkillService {
  private EmployeeSkillDao repository;

  public DefaultEmployeeSkillService(EmployeeSkillDao repository) {
    this.repository = repository;
  }


  public EmployeeSkill getEmployeeSkill(String employee, String skill) {
    if ((employee == null) || (employee.isEmpty())) {
      return null;
    } // end IF 1
    Optional<EmployeeSkill> employeeSkill = repository.get(employee, skill);
    if (employeeSkill.isEmpty()) {
      return null;
    } // end IF 2
    return employeeSkill.get();
  }// end GET

}// end CLASS
