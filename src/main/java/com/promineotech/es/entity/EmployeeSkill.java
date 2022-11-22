package com.promineotech.es.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeSkill {
  
  private String employeeId;
  private int skillId;
  
}
