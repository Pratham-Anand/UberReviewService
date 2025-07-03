package com.example.UberReviewService.services;
import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {      //command line runner tells what to do when we run the code


    private ReviewRepository reviewRepositoryobj;
    private final BookingRepository bookingRepository    ;
    private final DriverRepository driverRepository;// Review Repository object used here;

    public ReviewService(ReviewRepository reviewRepositoryobj, BookingRepository bookingRepository,DriverRepository driverRepository){

        this.reviewRepositoryobj=reviewRepositoryobj;
        this.bookingRepository= (BookingRepository) bookingRepository;
        this.driverRepository=driverRepository;
    }

@Override
    public void run(String... args ) throws Exception{
    System.out.println("*****************");
    Review r=Review.builder()
            .content("testing the JPA query")
//            .createdAt(new Date())               //we can auto populate these values
//            .updatedAt(new Date())
            .rating(6.0).build();
//
//    List<Review> reviews =reviewRepositoryobj.findAll();
//
//    for(Review review :reviews){
//        System.out.println(review.getContent());
//    }
//
//    System.out.println(r);
//    reviewRepositoryobj.save(r);    //this will help to save the object of this service in the database;

//    reviewRepositoryobj.deleteById(2L);

//    Booking b=Booking
//            .builder()
//            .review(r)
//            .endTime(new Date())
//            .build();
//
//    bookingRepository.save(b);


//    Optional<Booking> bo = bookingRepository.findById(1L);
//    List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//                for(Booking booking : bookings) {
//                    System.out.println(booking.getId());
//                }


//                Optional<Driver> drivers=driverRepository.rawfindByIdAndLicenseNumber(1L,"DL-09-123456");
    Optional<Driver> drivers=driverRepository.hqlfindByIdAndLicense(1L,"DL-09-123456");

    System.out.println(drivers.get().getId());

//    if(bo.isPresent()) {
//        bookingRepository.delete(bo.get());
//    }


}
}
