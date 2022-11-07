package com.promineotech.es.service;

import com.promineotech.es.entity.Skill;

public interface SkillService {

  Skill getSkill(String skill_ID);

  Skill deleteSkill(String skill_ID);

}
