package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;
import java.util.Optional;


@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {



    @Query("select r from Booking b inner join Review r on b.review=r where b.id = :bookingId")
    Review findReviewByBookingId(@Param("bookingId") Long bookingId);


    List<Review> findAllByRatingIsLessThanEqual(Integer rating);
    List<Review> findAllByCreatedAtBefore(Date date);

    Integer  countAllByRatingIsLessThanEqual(Integer givenRating);


}
