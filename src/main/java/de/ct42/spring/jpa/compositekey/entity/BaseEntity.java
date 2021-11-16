package de.ct42.spring.jpa.compositekey.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.SEQUENCE;

@MappedSuperclass
public abstract class BaseEntity {
  
  @Id
  @GeneratedValue(strategy = SEQUENCE)
  private long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
