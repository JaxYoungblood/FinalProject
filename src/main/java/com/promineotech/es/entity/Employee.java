package com.promineotech.es.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Employee {
  private String employeeId;
  private String departmentId;
  private String firstName;
  private String lastName;
  private String phone;
}
