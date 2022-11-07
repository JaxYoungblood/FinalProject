package com.promineotech.es.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.es.entity.Department;
import com.promineotech.es.service.DepartmentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@RestController
@OpenAPIDefinition(info = @Info(title = "Employee Skills"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
@RequestMapping("/department")

public class DepartmentController {
  private DepartmentService service;

  public DepartmentController(DepartmentService service) {
    this.service = service;
  }

  //READ
  @GetMapping(value = "{department_ID}") 
  public Department get(@PathVariable String department_ID) {
    Department department = service.getDepartment(department_ID);
    if (department != null) {
      return department;
    } // end IF
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
        "Sorry, the requested department was not found. Please try again!");
  }// end Skill READ


  //DELETE
  @DeleteMapping(value = "{department_ID}") 
  public Department delete(@PathVariable String department_ID) {
    if ((department_ID != null) && (!department_ID.isEmpty())) {
      Department existing = service.deleteDepartment(department_ID);
      if (existing != null) {
        return service.deleteDepartment(department_ID);
      } // end IF 2
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Sorry, the requested department was not found. Please try again!");
    } // end IF 1
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
        "Sorry, the input was empty or invalid. Please try again!");
  }// end Skill DELETE

}// end CLASS
