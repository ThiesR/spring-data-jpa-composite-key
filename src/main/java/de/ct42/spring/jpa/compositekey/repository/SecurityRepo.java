package de.ct42.spring.jpa.compositekey.repository;

import de.ct42.spring.jpa.compositekey.entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepo extends JpaRepository<Security, Long> {
  
}
