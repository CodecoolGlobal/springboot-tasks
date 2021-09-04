package com.codecool.spingboot_tasks.request_counter.controller;

import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

//@RequestScope
@RestController
public class RequestCounterController {

    private final List<String> shoppingCart;
    private final RequestCountStatsService service;
    
    @PostConstruct
    public void init() {
        System.out.println("Creating RequestCounterController");
    }
    
    @PreDestroy
    public void preDestroy() {
        System.out.println("RequestCounterController destroying...");
    }

    @Autowired
    public RequestCounterController(RequestCountStatsService service) throws InterruptedException {
        this.shoppingCart = new ArrayList<>();
        this.service = service;
    }

    @GetMapping("/api/requests")
    public ResponseEntity<Void> get() throws InterruptedException {
        System.out.println("request GET");
//        service.increaseCounter(RequestCountStatsService.GET);
        return ResponseEntity.ok().build();
    }
    
    
    @GetMapping("/api/stats")
    List<Statistics> getStatistics() {
        return service.getStatistics();
    }

    @PostMapping("/api/requests")
    public ResponseEntity<Void> post() {
//        service.increaseCounter(RequestCountStatsService.POST);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/requests")
    public ResponseEntity<Void> put() {
//        service.increaseCounter(RequestCountStatsService.PUT);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/requests")
    public ResponseEntity<Void> delete() {
//        service.increaseCounter(RequestCountStatsService.DELETE);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/requests")
    public ResponseEntity<Void> patch() {
//        service.increaseCounter(RequestCountStatsService.PATCH);
        return ResponseEntity.ok().build();
    }
}
