package com.promineotech.es.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.es.entity.Skill;
import com.promineotech.es.service.SkillService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@RestController
@OpenAPIDefinition(info = @Info(title = "Employee Skills"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
@RequestMapping("/skill")

public class SkillController {
  private SkillService service;

  public SkillController(SkillService service) {
    this.service = service;
  }

  @GetMapping(value = "{skill_ID}") // READ
  public Skill get(@PathVariable String skill_ID) {
    Skill skill = service.getSkill(skill_ID);
    if (skill != null) {
      return skill;
    } // end IF
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
        "Sorry, the requested skill was not found. Please try again!");
  }// end Skill READ


  @DeleteMapping(value = "{skill_ID}") // DELETE
  public Skill delete(@PathVariable String skill_ID) {
    if ((skill_ID != null) && (!skill_ID.isEmpty())) {
      Skill existing = service.deleteSkill(skill_ID);
      if (existing != null) {
        return service.deleteSkill(skill_ID);
      } // end IF 2
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Sorry, the requested skill was not found. Please try again!");
    } // end IF 1
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
        "Sorry, the input was empty or invalid. Please try again!");
  }// end Skill DELETE

}// end CLASS
