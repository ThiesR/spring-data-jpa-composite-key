package de.ct42.spring.jpa.compositekey.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;

@Entity
@IdClass(RateId.class)
@Table(indexes = @Index(name = "idx_securityRate_security_price_date", columnList = "priceDate,security_id", unique = true))
public class SecurityRate extends BaseEntity {

  @Id
  private LocalDate priceDate;

  @ManyToOne(cascade = ALL)
  @JoinColumn(name = "security_id")
  private Security security;
  
  @Column(precision = 19, scale = 6)
  private BigDecimal rate;

  public LocalDate getPriceDate() {
    return priceDate;
  }

  public void setPriceDate(LocalDate priceDate) {
    this.priceDate = priceDate;
  }

  public Security getSecurity() {
    return security;
  }

  public void setSecurity(Security security) {
    this.security = security;
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
