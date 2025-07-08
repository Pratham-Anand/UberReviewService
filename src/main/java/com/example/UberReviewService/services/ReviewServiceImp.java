package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImp implements ReviewService {


    private final ReviewRepository reviewRepository;

    public ReviewServiceImp(ReviewRepository reviewRepository){
    this.reviewRepository=reviewRepository;
    }


    @Override
    public Review publishReview(Review review){
        return  this.reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id,Review newreview){
        Review review=reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if(newreview.getContent()!=null){
            review.setContent(newreview.getContent());
        }
        if(newreview.getRating()!=null){
            review.setRating(newreview.getRating());
        }
        return this.reviewRepository.save(review);


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
