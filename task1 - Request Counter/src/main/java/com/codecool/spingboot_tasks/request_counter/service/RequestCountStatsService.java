package com.codecool.spingboot_tasks.request_counter.service;

import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import org.springframework.boot.actuate.endpoint.web.Link;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@Scope("prototype")
@Service
public class RequestCountStatsService {

    public static String GET = "GET";
    public static String POST = "POST";
    public static String PUT = "PUT";
    public static String DELETE = "DELETE";
    public static String PATCH = "PATCH";
    /*
     * Map holding statistics of methods execution. key is method name: GET,PUT etc.
     * value is and integer number representing number of executions
     */
    private final Map<String, Integer> stats = new HashMap<>();

    public void increaseCounter(String method) {

//        stats.merge(method, 1, Integer::sum);

        if (stats.containsKey(method)) {
            stats.put(method, stats.get(method) + 1);
        } else {
            stats.put(method, 1);
        }
    }

    public List<Statistics> getStatistics() {
        return stats.entrySet()
                .stream()
                .map(e -> new Statistics(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }
}
