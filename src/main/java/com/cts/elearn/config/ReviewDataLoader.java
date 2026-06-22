package com.cts.elearn.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cts.elearn.entity.Review;
import com.cts.elearn.repository.ReviewRepository;

@Configuration
public class ReviewDataLoader {

    @Bean
    CommandLineRunner loadReviews(
            ReviewRepository repo) {

        return args -> {

            if(repo.count() == 0) {

                Review review1 = new Review();

                review1.setCourseId(1L);
                review1.setLearnerId(2L);
                review1.setReviewText(
                        "Excellent Java backend course. Very practical.");
                review1.setRating(5);
                review1.setCreatedAt(
                        LocalDateTime.now());

                repo.save(review1);

                Review review2 = new Review();

                review2.setCourseId(2L);
                review2.setLearnerId(2L);
                review2.setReviewText(
                        "Kafka concepts explained clearly.");
                review2.setRating(4);
                review2.setCreatedAt(
                        LocalDateTime.now());

                repo.save(review2);

                Review review3 = new Review();

                review3.setCourseId(4L);
                review3.setLearnerId(2L);
                review3.setReviewText(
                        "Useful for TS LAWCET preparation.");
                review3.setRating(5);
                review3.setCreatedAt(
                        LocalDateTime.now());

                repo.save(review3);

                System.out.println(
                        "Sample Reviews Loaded");
            }
        };
    }
}