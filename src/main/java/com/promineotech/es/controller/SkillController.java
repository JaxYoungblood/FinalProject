package com.promineotech.es.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.es.entity.Skill;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;

@Validated
@RequestMapping("/skill")
@OpenAPIDefinition(info = @Info(title = "Employee Skills"),
servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface SkillController {
//@formatter:off
//READ
  @Operation(
      summary = "Returns a description of a skill",
      description = "Returns a skill desription, given a required skill ID",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A skill description is returned.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Skill.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No skills were found with the given skill ID.", 
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
              name = "skillId",
              allowEmptyValue = false,
              required = false,
              description = "The skill ID (i.e., '001')") 
     }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Skill> getSkill(
      @RequestParam(required = false)
      int skillId);
 
  
//DELETE
  @Operation(
      summary = "Deletes a skill",
      description = "Delete a skill given a required skill ID",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A skill is deleted.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Skill.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No skills were found with the input criteria.", 
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
              name = "skillId",
              allowEmptyValue = false,
              required = false,
              description = "The skill ID (i.e., '001')") 
      }
  )
   @DeleteMapping
   @ResponseStatus(code = HttpStatus.OK)
   Optional<Skill> deleteSkill(
       @RequestParam(required = false)
       int skillId);
   
   //@formatter:on
 }