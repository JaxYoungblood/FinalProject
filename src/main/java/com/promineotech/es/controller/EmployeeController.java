package com.promineotech.es.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.es.entity.Employee;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@Validated
@OpenAPIDefinition(info = @Info(title = "Employee Skills"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
@RequestMapping("/employee")

public interface EmployeeController {
//@formatter:off
  
//READ
  @Operation(
      summary = "Returns a list of employee details",
      description = "Returns a list of employee details, given a required employee ID",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of employee details is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Employee.class))),
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
              name = "employeeId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The employee ID (Last name + _ + First name, i.e. 'Smith_John')")
     }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Employee> getEmployee(
      @RequestParam(required = false)
      String employeeId);
 
  
//CREATE
  @Operation(
      summary = "Creates a new employee",
      description = "Create a new employee using a required criteria",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A new employee is created!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Employee.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to create a new employee with the input criteria.", 
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
              name = "employeeId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The employee ID (Last name + _ + First name, i.e. 'Smith_John')"),
          @Parameter(
              name = "departmentId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The department ID (i.e., 'HR')"), 
          @Parameter(
              name = "firstName",
              allowEmptyValue = false,
              required = false,
              description = "The employee's first name (i.e., 'John')"),
          @Parameter(
              name = "lastName",
              allowEmptyValue = false,
              required = false,
              description = "The employee's last name (i.e., 'Smith')"),
          @Parameter(
              name = "phone",
              allowEmptyValue = false,
              required = false,
              description = "The employee's phone number (i.e., '5095352345')")
      }
  )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Employee> createEmployee(
     @RequestParam(required = false) 
     String employeeId,
     @RequestParam(required = false) 
     String departmentId,
     @RequestParam(required = false)
     String firstName,
     @RequestParam(required = false)
     String lastName,
     @RequestParam(required = false)
     String phone);  
  
  
//UPDATE
  @Operation(
      summary = "Updates an employee",
      description = "Update an employee using a required criteria",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "The employee was updated!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Employee.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to update the employee with the input criteria.", 
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
              name = "employeeId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The employee ID (Last name + _ + First name, i.e. 'Smith_John')"),
          @Parameter(
              name = "departmentId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The department ID (i.e., 'HR')"), 
          @Parameter(
              name = "firstName",
              allowEmptyValue = false,
              required = false,
              description = "The employee's first name (i.e., 'John')"),
          @Parameter(
              name = "lastName",
              allowEmptyValue = false,
              required = false,
              description = "The employee's last name (i.e., 'Smith')"),
          @Parameter(
              name = "phone",
              allowEmptyValue = false,
              required = false,
              description = "The employee's phone number (i.e., '5095352345')")
      }
  )
  
 @PutMapping
 @ResponseStatus(code = HttpStatus.OK)
 Optional<Employee> updateEmployee(
     @RequestParam(required = false) 
     String employee_ID,
     @RequestParam(required = false) 
     String departmentId,
     @RequestParam(required = false)
     String firstName,
     @RequestParam(required = false)
     String lastName,
     @RequestParam(required = false)
     String phone,
     @RequestParam(required = false) 
     String newDepartmentId,
     @RequestParam(required = false)
     String newFirstName,
     @RequestParam(required = false)
     String newLastName,
     @RequestParam(required = false)
     String newPhone);  
  
  
//DELETE
 @Operation(
     summary = "Deletes an employee",
     description = "Delete an employee given a required employee ID",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "The employee was deleted.", 
             content = @Content(
                 mediaType = "application/json", 
             schema = @Schema(implementation = Employee.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid.", 
             content = @Content(
                 mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No employees were found with that employee ID.", 
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
             name = "employeeId",
             allowEmptyValue = false,
             required = false,
             description = "The employee ID (Last name + _ + First name, i.e. 'Smith_John')")
     }
 )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Employee> deleteEmployee(
      @RequestParam(required = false)
      String employeeId);
  
  //@formatter:on
}

