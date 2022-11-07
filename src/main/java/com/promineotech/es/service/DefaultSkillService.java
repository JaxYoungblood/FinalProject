package com.promineotech.es.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.es.dao.SkillDao;
import com.promineotech.es.entity.Skill;

@Service
public class DefaultSkillService implements SkillService {
  private SkillDao repository;

  public DefaultSkillService(SkillDao repository) {
    this.repository = repository;
  }


  public Skill getSkill(String skill_ID) {
    if ((skill_ID == null) || (skill_ID.isEmpty())) {
      return null;
    } // end IF 1
    Optional<Skill> Skill = repository.get(skill_ID);
    if (Skill.isEmpty()) {
      return null;
    } // end IF 2
    return Skill.get();
  }// end GET


  public Skill deleteSkill(String skill_ID) {
    if ((skill_ID == null) || (skill_ID.isEmpty())) {
      return null;
    } // end IF 1
    Optional<Skill> deleted = repository.delete(skill_ID);
    if (deleted.isPresent()) {
      return deleted.get();
    } // end IF 2
    return null;
  }// end DELETE

}// end CLASS
