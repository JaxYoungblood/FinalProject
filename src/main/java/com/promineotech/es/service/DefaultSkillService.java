package com.promineotech.es.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.es.dao.SkillDao;
import com.promineotech.es.entity.Skill;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DefaultSkillService implements SkillService {
  
  @Autowired
  private SkillDao skillDao;

  
  @Transactional(readOnly = true)
  @Override
  public List<Skill> getSkill(int skillId) {
    log.info("The getSkill method was called with skillId={}", skillId);
    
    return skillDao.getSkill(skillId);
  }


  @Override
  public Optional<Skill> deleteSkill(int skillId) {
   
    return skillDao.deleteSkill(skillId); 
  }

}
