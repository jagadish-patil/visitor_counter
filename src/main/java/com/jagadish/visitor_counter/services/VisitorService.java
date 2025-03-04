package com.jagadish.visitor_counter.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jagadish.visitor_counter.models.VisitorStat;
import com.jagadish.visitor_counter.repositories.VisitorStatRepository;

@Service
public class VisitorService {

	@Autowired
	private VisitorStatRepository visitorStatRepository;
	
	public long getTotalVisitors() {
        return visitorStatRepository.count();
    }
	
	public long getUniqueVisitors(LocalDate today) {
        return visitorStatRepository.countByVisitDate(today);
    }
	
	public void trackVisitor(String ipAddress) {
        LocalDate today = LocalDate.now();
        if (visitorStatRepository.countByIpAddressAndVisitDate(ipAddress, today) == 0) {
            VisitorStat stat = new VisitorStat();
            stat.setIpAddress(ipAddress);
            stat.setVisitDate(today);
            visitorStatRepository.save(stat);
        }
    }
	
}
