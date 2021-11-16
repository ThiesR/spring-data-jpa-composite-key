package de.ct42.spring.jpa.compositekey.service;

import de.ct42.spring.jpa.compositekey.dto.SecurityRateDto;
import de.ct42.spring.jpa.compositekey.entity.Security;
import de.ct42.spring.jpa.compositekey.entity.SecurityRate;
import de.ct42.spring.jpa.compositekey.repository.SecurityRateRepo;
import de.ct42.spring.jpa.compositekey.repository.SecurityRepo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.now;

@Service
public class SecurityService {

  private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(SecurityService.class.getName());

  @Autowired
  SecurityRepo securityRepo;

  @Autowired
  SecurityRateRepo securityRateRepo;

  @Transactional
  public List<Security> createSecurities() {
    List<Security> newSecurities = new ArrayList<>();
    for (int x = 0; x < 30; x++) {
      Security security = new Security();
      security.setName("Sec_" + x);
      newSecurities.add(security);
    }
    return securityRepo.saveAll(newSecurities);
  }

  @Transactional
  public void saveSecurityRates(List<SecurityRateDto> dtos) {
    List<SecurityRate> newRates = new ArrayList<>();

    dtos.forEach(dto -> {
      SecurityRate rate = new SecurityRate();
      rate.setPriceDate(dto.getPriceDate());
      rate.setSecurity(securityRepo.findById(dto.getSecurityId()).orElse(null));
      rate.setRate(dto.getRate());
      newRates.add(rate);
    });
    List<SecurityRate> persisted = securityRateRepo.saveAll(newRates);
    persisted.forEach(securiyRate -> LOG.info(() -> "Saved: " + securiyRate));
  }

}
