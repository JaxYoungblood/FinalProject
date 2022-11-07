package com.promineotech.es.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.es.entity.Employee;
import com.promineotech.es.entity.InputEmployee;
import com.promineotech.es.service.EmployeeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@OpenAPIDefinition(info = @Info(title = "Employee Skills"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
@RequestMapping("/employee")

public class EmployeeController {
  private EmployeeService service;

  public EmployeeController(EmployeeService service) {
    this.service = service;
  }


  @GetMapping(value = "{id}") // READ
  public Employee get(@PathVariable String id) {
    Employee employee = service.getEmployee(id);
    if (employee != null) {
      return employee;
    } // end IF
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
        "Sorry, the requested employee was not found. Please try again!");
  }// end Employee GET


  @PostMapping(value = "{input}") // CREATE
  public Employee create(@Valid @RequestBody InputEmployee input) {
    if (input != null) {
      if (!input.isValid()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            "Sorry, the input was empty or invalid. Please try again!");
      } // end IF 2
      Employee result = service.createEmployee(input);
      if (result != null) {
        return result;
      } // end IF 3
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
          "Internal Error. Please try again!");
    } // end IF 1
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
        "Sorry, the input was empty or invalid. Please try again!");
  }// end Employee CREATE


  @PutMapping // UPDATE
  public Employee update(@RequestBody InputEmployee input) {
    if (input != null) {
      if (!input.isValid()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            "Sorry, the input was empty or invalid. Please try again!");
      } // end IF 2
      Employee result = service.updateEmployee(input);
      if (result != null) {
        return result;
      } // end IF 3
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
          "Internal Error. Please try again!");
    } // end IF 1
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
        "Sorry, the input was empty or invalid. Please try again!");
  }// end Employee UPDATE


  @DeleteMapping(value = "{id}") // DELETE
  public Employee delete(@PathVariable String id) {
    if ((id != null) && (!id.isEmpty())) {
      Employee existing = service.getEmployee(id);
      if (existing != null) {
        return service.deleteEmployee(id);
      } // end IF 2
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Sorry, the requested employee was not found. Please try again!");
    } // end IF 1
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
        "Sorry, the input was empty or invalid. Please try again!");
  }// end Employee DELETE


}// end CLASS
