package com.promineotech.es.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.es.entity.EmployeeSkill;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;


@Validated
@OpenAPIDefinition(info = @Info(title = "Employee Skills"),
servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
@RequestMapping("/employee_skill")

public interface EmployeeSkillController {
//@formatter:off
  
//READ 
  @Operation(
      summary = "Returns a list of employee skills",
      description = "Returns a list of employee skills given a required employee ID",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of employee skills is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = EmployeeSkill.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No employees were found with the input criteria.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "employeeID", 
              allowEmptyValue = false, 
              required = false, 
              description = "The employee ID (i.e., 'SMITH_JOHN')"),  
     }
  )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<EmployeeSkill> getEmployeeSkill(
      @RequestParam(required = false) 
      String employeeID);
 
  
}
