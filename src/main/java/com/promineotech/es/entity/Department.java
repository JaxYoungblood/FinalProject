package com.promineotech.es.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Department {
  private String department_ID;
  private String description;
}

