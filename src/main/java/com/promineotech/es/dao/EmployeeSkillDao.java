package com.promineotech.es.dao;

import java.util.List;
import com.promineotech.es.entity.EmployeeSkill;

public interface EmployeeSkillDao {

  List<EmployeeSkill> getEmployeeSkill(String employeeId);

}
