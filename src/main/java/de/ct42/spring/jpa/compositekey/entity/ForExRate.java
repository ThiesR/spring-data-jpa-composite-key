package de.ct42.spring.jpa.compositekey.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@IdClass(RateId.class)
public class ForExRate extends BaseEntity {

  @Id
  private LocalDate priceDate;

  private long securityId;
  
  @Column(precision = 19, scale = 6)
  private BigDecimal rate;

  public LocalDate getPriceDate() {
    return priceDate;
  }

  public void setPriceDate(LocalDate priceDate) {
    this.priceDate = priceDate;
  }

  public long getSecurityId() {
    return securityId;
  }

  public void setSecurityId(long securityId) {
    this.securityId = securityId;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  @Override
  public String toString() {
    return "SecurityRate [id=" + getId() + ", priceDate=" + priceDate + ", rate=" + rate + "]";
  }
  
  
}
