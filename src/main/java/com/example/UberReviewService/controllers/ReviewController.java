package com.example.UberReviewService.controllers;


import com.example.UberReviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.uberreviewservice.dtos.ReviewDto;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private ReviewService reviewService;
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;


    public ReviewController(ReviewService reviewService,CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter){
        this.reviewService=reviewService;
        this.createReviewDtoToReviewAdapter=createReviewDtoToReviewAdapter;
    }

    @PostMapping
    public ResponseEntity<?> publishReview(@Validated @RequestBody CreateReviewDto request){
        Review incomingReview= createReviewDtoToReviewAdapter.convertDto(request);
        if(incomingReview == null) {
            return new ResponseEntity<>("Invalid arguments", HttpStatus.BAD_REQUEST);
        }
        Review review=this.reviewService.publishReview(incomingReview);

//        ReviewDto response= ReviewDto.builder()
//                .id(review.getId())
//                .content(review.getContent())
//                .booking(review.getBooking().getId())
//                .rating(review.getRating())
//                .createdAt(review.getCreatedAt())
//                .updatedAt(review.getUpdatedAt())
//                .build();

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews=this.reviewService.finalAllReviews();

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?>getReviewById(@PathVariable("reviewId") Long reviewId){
        try {
            Optional<Review> review = this.reviewService.findReviewById(reviewId);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?>deleteReviewById(@PathVariable("reviewId") Long id){
        try {
            Boolean isDeleted = reviewService.deleteReviewById(id);

            if (!isDeleted)
                return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?>updateReview(@PathVariable("reviewId") Long id,@RequestBody Review request){
       try {
           Review review = reviewService.updateReview(id, request);
           return new ResponseEntity<>(review, HttpStatus.OK);
       }
       catch(Exception e){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       }


    }
}
