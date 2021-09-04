package com.codecool.spingboot_tasks.request_counter.filter;

import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class RequestCounterFilter implements Filter {

    private final RequestCountStatsService requestCountStatsService;

    @Autowired
    public RequestCounterFilter(
            RequestCountStatsService requestCountStatsService) {
        this.requestCountStatsService = requestCountStatsService;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("RequestCounterFilter execution starts");
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("request path: " + req.getServletPath());
        if (req.getServletPath().contains("/stats")) {
            requestCountStatsService.increaseCounter(req.getMethod());
        }
        chain.doFilter(request, response);
        System.out.println("RequestCounterFilter execution stops");

    }
}
