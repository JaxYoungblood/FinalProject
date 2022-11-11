package com.promineotech.es.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.es.dao.SkillDao;
import com.promineotech.es.entity.Skill;

@Service
public class DefaultSkillService implements SkillService {
  private SkillDao skillDao;


  public Skill getSkill(String skill_ID) {
    if ((skill_ID == null) || (skill_ID.isEmpty())) {
      return null;
    } // end IF 1
    List<Skill> Skill = skillDao.get(skill_ID);
    if (Skill.isEmpty()) {
      return null;
    } // end IF 2
    return Skill.get(0);
  }// end GET


  public Skill deleteSkill(String skill_ID) {
    if ((skill_ID == null) || (skill_ID.isEmpty())) {
      return null;
    } // end IF 1
    List<Skill> deleted = skillDao.delete(skill_ID);
    if (deleted.isPresent()) {
      return deleted.get(0);
    } // end IF 2
    return null;
  }// end DELETE

}// end CLASS
