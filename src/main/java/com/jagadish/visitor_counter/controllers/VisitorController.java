package com.jagadish.visitor_counter.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagadish.visitor_counter.services.VisitorService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/visitors")
public class VisitorController {

	@Autowired
	private VisitorService visitorService;
	
	@GetMapping("/tarck")
	public Map<String, Object> trackVisitor(HttpServletRequest request){
		String ipAddress = request.getRemoteAddr();
		visitorService.trackVisitor(ipAddress);
		
		Map<String, Object> response = new HashMap<>();
		response.put("totalVisitors", visitorService.getTotalVisitors());
		response.put("uniqueVisitors", visitorService.getUniqueVisitors(LocalDate.now()));
		
		return response;
	} 
	
}
