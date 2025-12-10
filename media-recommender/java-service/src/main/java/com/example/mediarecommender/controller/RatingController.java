package com.example.mediarecommender.controller;

import com.example.mediarecommender.model.Rating;
import com.example.mediarecommender.model.Recommendation;
import com.example.mediarecommender.repository.RatingRepository;
import com.example.mediarecommender.repository.RecommendationRepository;
import com.example.mediarecommender.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow all origins for Cloud IDE previews
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("/ratings")
    public Rating addRating(@RequestBody Rating rating) {
        Rating savedRating = ratingRepository.save(rating);
        // Trigger async recommendation update
        recommendationService.triggerRecommendationUpdate();
        return savedRating;
    }

    @GetMapping("/recommendations")
    public List<Recommendation> getRecommendations() {
        return recommendationRepository.findAll();
    }
}
