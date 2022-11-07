package com.promineotech.es.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeSkill {
  private String employee_ID;
  private int skill_ID;
}
