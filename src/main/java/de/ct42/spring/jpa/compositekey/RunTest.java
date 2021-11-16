package de.ct42.spring.jpa.compositekey;

import de.ct42.spring.jpa.compositekey.dto.SecurityRateDto;
import de.ct42.spring.jpa.compositekey.entity.Security;
import de.ct42.spring.jpa.compositekey.entity.SecurityRate;
import de.ct42.spring.jpa.compositekey.service.SecurityService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.time.LocalDate.now;
import static java.util.stream.Collectors.toList;

@Component
public class RunTest {
  
  @Autowired
  SecurityService service;

  @PostConstruct
  public void runTest() {
    List<SecurityRateDto> rates = new ArrayList<>(); 
    List<Security> securities = service.createSecurities();
    List<LocalDate> dates = IntStream.range(0, 600).mapToObj(i -> now().plusDays(i)).collect(toList());
    securities.forEach(security -> {
      dates.forEach(date -> {
        SecurityRateDto dto = new SecurityRateDto();
        dto.setSecurityId(security.getId());
        dto.setPriceDate(date);
        dto.setRate(BigDecimal.valueOf(Math.random() * 300.0));
        rates.add(dto);
      });
    });
    service.saveSecurityRates(rates);
  }

}
