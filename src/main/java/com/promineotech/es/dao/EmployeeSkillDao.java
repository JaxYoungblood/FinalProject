package com.promineotech.es.dao;

import java.util.List;
//import java.util.Optional;
import com.promineotech.es.entity.EmployeeSkill;

public interface EmployeeSkillDao {

  List<EmployeeSkill> get(String employee, String skill);

}
