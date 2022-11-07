package com.promineotech.es.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.es.entity.EmployeeSkill;
import com.promineotech.es.service.EmployeeSkillService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@RestController
@OpenAPIDefinition(info = @Info(title = "Employee Skills"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
@RequestMapping("/employee_skill")
public class EmployeeSkillController {
  private EmployeeSkillService service;

  public EmployeeSkillController(EmployeeSkillService service) {
    this.service = service;
  }

  @GetMapping(value = "{order}") // READ
  public EmployeeSkill get(@PathVariable String employee, String skill) {
    EmployeeSkill employeeSkill = service.getEmployeeSkill(employee, skill);
    if (employeeSkill != null) {
      return employeeSkill;
    } // end IF

    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
        "Sorry, the requested employee skill was not found. Please try again!");
  }// end READ

}// end CLASS
