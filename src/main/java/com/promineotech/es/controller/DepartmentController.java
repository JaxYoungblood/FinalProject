package com.promineotech.es.controller;

//import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.es.entity.Department;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;


@Validated
@OpenAPIDefinition(info = @Info(title = "Employee Skills"),
servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
@RequestMapping("/department")


public interface DepartmentController {
//@formatter:off

  
//CREATE
  @Operation(
      summary = "Creates a department",
      description = "Create a new department using a required department ID and description",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A new department was created!", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Department.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to create new department with the input criteria.", 
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
              name = "departmentId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The department ID (i.e., 'HR')"), 
          @Parameter(
              name = "description",
              allowEmptyValue = false,
              required = false,
              description = "The department description (i.e., 'Human Resources')")
      }
  )

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Department> createDepartment(
     @RequestParam(required = false) 
     String departmentId,
     @RequestParam(required = false)
     String description);  
  
     
//DELETE
  @Operation(
      summary = "Deletes a department",
      description = "Delete a department given a required department id",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A department is deleted.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Department.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No departments were found with the input criteria.", 
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
              name = "departmentId", 
              allowEmptyValue = false, 
              required = false, 
              description = "The department ID (i.e., 'HR')") 
      }
  )
   @DeleteMapping
   @ResponseStatus(code = HttpStatus.OK)
   Optional<Department> deleteDepartment(
       @RequestParam(required = false)
       String departmentId);
   
   //@formatter:on
  
 }