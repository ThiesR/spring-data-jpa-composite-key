package de.ct42.spring.jpa.compositekey.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SecurityRateDto {

  private long securityId;

  private LocalDate priceDate;

  private BigDecimal rate;

  public long getSecurityId() {
    return securityId;
  }

  public void setSecurityId(long securityId) {
    this.securityId = securityId;
  }

  public LocalDate getPriceDate() {
    return priceDate;
  }

  public void setPriceDate(LocalDate priceDate) {
    this.priceDate = priceDate;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }  
}
