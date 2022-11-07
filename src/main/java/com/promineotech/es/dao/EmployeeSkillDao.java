package com.promineotech.es.dao;

import java.util.Optional;
import com.promineotech.es.entity.EmployeeSkill;

public interface EmployeeSkillDao {

  Optional<EmployeeSkill> get(String employee, String skill);

}
