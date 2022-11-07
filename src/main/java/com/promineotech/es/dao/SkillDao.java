package com.promineotech.es.dao;

import java.util.Optional;
import com.promineotech.es.entity.Skill;

public interface SkillDao {

  Optional<Skill> get(String skill_ID);

  Optional<Skill> delete(String skill_ID);

}
