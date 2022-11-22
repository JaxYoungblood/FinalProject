package com.promineotech.es.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.es.entity.Skill;
import com.promineotech.es.service.SkillService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultSkillController {
  
  @Autowired
  private SkillService service;

  
//READ
  //@Override
  public List<Skill> getSkill(int skillId) {
    log.info("skillId={}", skillId); 
    
    return service.getSkill(skillId); 
  }

//DELETE
  //@Override
  public Optional<Skill> deleteSkill(int skillId) {
    log.info("skillId={}", skillId);
   
    return service.deleteSkill(skillId); 
  }

}
