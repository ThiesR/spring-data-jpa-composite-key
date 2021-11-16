package de.ct42.spring.jpa.compositekey.repository;

import de.ct42.spring.jpa.compositekey.entity.RateId;
import de.ct42.spring.jpa.compositekey.entity.SecurityRate;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRateRepo extends JpaRepository<SecurityRate, RateId> {

  
  Optional<SecurityRate> findBySecurity_IdAndPriceDate(long securityId, LocalDate priceDate);
  
}
