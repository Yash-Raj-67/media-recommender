package com.example.mediarecommender.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecommendationService {

    @Value("${python.service.url}")
    private String pythonServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @Async
    public void triggerRecommendationUpdate() {
        try {
            // We just hit the process endpoint. It's a fire-and-forget from Java's perspective
            // because the Python service will read from DB and write to DB.
            String url = pythonServiceUrl + "/process";
            System.out.println("Triggering Python service at: " + url);
            restTemplate.postForObject(url, null, String.class);
        } catch (Exception e) {
            System.err.println("Error triggering Python service: " + e.getMessage());
            // In a real app we might want to retry or log this better
        }
    }
}
