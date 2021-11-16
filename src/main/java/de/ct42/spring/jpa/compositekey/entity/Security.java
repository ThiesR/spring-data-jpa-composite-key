package de.ct42.spring.jpa.compositekey.entity;

import javax.persistence.Entity;

@Entity
public class Security extends BaseEntity {

  private String name;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
