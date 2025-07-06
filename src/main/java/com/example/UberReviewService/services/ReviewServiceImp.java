package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImp implements ReviewService {


    private ReviewRepository reviewRepository;

    public ReviewServiceImp(DriverRepository driverRepository,ReviewRepository reviewRepository,BookingRepository bookingRepository){
    this.reviewRepository=reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id){
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> finalAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id) {
       try{
           reviewRepository.deleteById(id);
           return true;
       }
       catch(Exception e){
           return false;
       }
    }
}
