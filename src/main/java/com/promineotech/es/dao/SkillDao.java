package com.promineotech.es.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.es.entity.Skill;

public interface SkillDao {

  List<Skill> getSkill(int skillId);
  
  Optional<Skill> createSkill(int skillId, String description);

  Optional<Skill> deleteSkill(int skillId);

}
