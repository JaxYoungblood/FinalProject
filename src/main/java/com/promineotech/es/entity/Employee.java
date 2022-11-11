package com.promineotech.es.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Employee {
  private String employee_ID;
  private String department_ID;
  private String first_name;
  private String last_name;
  private String phone;
}
