package de.ct42.spring.jpa.compositekey.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class RateId implements Serializable {

  long id;

  LocalDate priceDate;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public LocalDate getPriceDate() {
    return priceDate;
  }

  public void setPriceDate(LocalDate priceDate) {
    this.priceDate = priceDate;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((priceDate == null) ? 0 : priceDate.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    RateId other = (RateId) obj;
    if (id != other.id)
      return false;
    if (priceDate == null) {
      if (other.priceDate != null)
        return false;
    } else if (!priceDate.equals(other.priceDate))
      return false;
    return true;
  }  
}
