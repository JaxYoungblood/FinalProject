package com.promineotech.es.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.es.entity.Department;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultDepartmentDao implements DepartmentDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;


//CREATE
  @Override
  public Optional<Department> createDepartment(String departmentId, String description) {
    log.info("DAO: departmentId={}, description={}", departmentId, description);

   //@formatter:off
   String sql = ""
       + "INSERT INTO department ("
       + "department_ID, description"
       + ") VALUES ("
       +  ":department_ID, :description)";

    Map<String, Object> params = new HashMap<>();
    params.put("department_ID", departmentId);
    params.put("description", description.toString());

    jdbcTemplate.update(sql, params);
    
    return Optional
        .ofNullable(Department.builder()
            .departmentId(departmentId)
            .description(description)
            .build());
  }


//DELETE
  @Override
  public Optional<Department> deleteDepartment(String departmentId) {
    // is this SQL correct????????????????????????????????????????????????????????????
    String sql = "" 
        + "DELETE FROM department "
        + "WHERE department_ID = :department_ID;";

    Map<String, Object> params = new HashMap<>();
    params.put("department_ID", departmentId);

    jdbcTemplate.update(sql, params);

    return Optional.ofNullable(Department.builder().departmentId(departmentId).build());
  }


}
