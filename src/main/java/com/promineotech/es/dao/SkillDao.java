package com.promineotech.es.dao;

import java.util.List;
//import java.util.Optional;
import com.promineotech.es.entity.Skill;

public interface SkillDao {

  List<Skill> get(String skill_ID);

  List<Skill> delete(String skill_ID);

}
