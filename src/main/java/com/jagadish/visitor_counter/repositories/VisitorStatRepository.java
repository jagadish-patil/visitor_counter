package com.jagadish.visitor_counter.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jagadish.visitor_counter.models.VisitorStat;

public interface VisitorStatRepository extends JpaRepository<VisitorStat, Long> {

	long countByVisitDate(LocalDate visitDate);
    long countByIpAddressAndVisitDate(String ipAddress, LocalDate visitDate);
    
}
