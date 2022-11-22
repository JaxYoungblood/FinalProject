package com.promineotech.es.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Skill {
  
  private int skillId;
  private String description;
}
