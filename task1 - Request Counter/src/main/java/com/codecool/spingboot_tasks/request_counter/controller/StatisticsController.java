package com.codecool.spingboot_tasks.request_counter.controller;

import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsController {
   
   private final RequestCountStatsService requestCountStatsService;
   
   @Autowired
   public StatisticsController(
		   RequestCountStatsService requestCountStatsService) {
	  this.requestCountStatsService = requestCountStatsService;
   }
   
   @GetMapping("/api/ping")
   public String ping() {
      return "Ping!";
   }

}
