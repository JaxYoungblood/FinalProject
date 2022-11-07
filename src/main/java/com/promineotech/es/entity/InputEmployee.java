package com.promineotech.es.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InputEmployee {

  private String departmentID;
  private String firstName;
  private String lastName;
  private String phoneNumber;

  public String getDepartmentID() {
    return departmentID;
  }

  public InputEmployee setDepartmentID(String departmentID) {
    this.departmentID = departmentID;
    return this;
  }
  
  public String getFirstName() {
    return firstName;
  }

  public InputEmployee setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public InputEmployee setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public InputEmployee setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  @JsonIgnore
  public boolean isValid() {
    //@formatter:off
    return (getDepartmentID() != null) && (!getDepartmentID().isEmpty()) 
        && (getFirstName() != null) && (!getFirstName().isEmpty()) 
        && (getLastName() != null) && (!getLastName().isEmpty()) 
        && (getPhoneNumber() != null) && (!getPhoneNumber().isEmpty());
    //@formatter:on
 }// end BOOLEAN


}// end CLASS

