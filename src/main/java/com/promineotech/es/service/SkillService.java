package com.promineotech.es.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.es.entity.Skill;

public interface SkillService {

  List<Skill> getSkill(int skillId);

  Optional<Skill> deleteSkill(int skillId);

}
