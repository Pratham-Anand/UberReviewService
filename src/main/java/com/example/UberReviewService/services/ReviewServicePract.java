//package com.example.UberReviewService.services;
//import com.example.UberReviewService.models.Booking;
//import com.example.UberReviewService.models.Driver;
//import com.example.UberReviewService.models.Review;
//import com.example.UberReviewService.repositories.BookingRepository;
//import com.example.UberReviewService.repositories.DriverRepository;
//import com.example.UberReviewService.repositories.ReviewRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class ReviewService implements CommandLineRunner {
//
//    private final ReviewRepository reviewRepository;
//
//    public ReviewService(ReviewRepository reviewRepository) {
//        this.reviewRepository = reviewRepository;
//    }      //command line runner tells what to do when we run the code
////
////
////    private ReviewRepository reviewRepositoryobj;
////    private final BookingRepository bookingRepository    ;
////    private final DriverRepository driverRepository;// Review Repository object used here;
////
////    public ReviewService(ReviewRepository reviewRepositoryobj, BookingRepository bookingRepository,DriverRepository driverRepository){
////
////        this.reviewRepositoryobj=reviewRepositoryobj;
////        this.bookingRepository= (BookingRepository) bookingRepository;
////        this.driverRepository=driverRepository;
////    }
//
//@Override
//@Transactional
//    public void run(String... args ) throws Exception{
//    System.out.println("*****************");
//    Review r=Review.builder()
//            .content("testing the JPA query")
////            .createdAt(new Date())               //we can auto populate these values
////            .updatedAt(new Date())
//            .rating(6.0).build();
////
////    List<Review> reviews =reviewRepositoryobj.findAll();
////
////    for(Review review :reviews){
////        System.out.println(review.getContent());
////    }
////
////    System.out.println(r);
////    reviewRepositoryobj.save(r);    //this will help to save the object of this service in the database;
//
////    reviewRepositoryobj.deleteById(2L);
//
////    Booking b=Booking
////            .builder()
////            .review(r)
////            .endTime(new Date())
////            .build();
////
////    bookingRepository.save(b);
//
//
////    Optional<Booking> bo = bookingRepository.findById(1L);
////    List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
////                for(Booking booking : bookings) {
////                    System.out.println(booking.getId());
////                }
//
//
////                Optional<Driver> drivers=driverRepository.rawfindByIdAndLicenseNumber(1L,"DL-09-123456");
////    Optional<Driver> drivers=driverRepository.hqlfindByIdAndLicense(1L,"DL-09-123456");
//
////    System.out.println(drivers.get().getId());
//
////    if(bo.isPresent()) {
////        bookingRepository.delete(bo.get());
////    }
//
//
//    List<Long> driverIds = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 5L, 6L, 7L, 8L));
//    List<Driver>drivers =driverRepository.findAllByIdIn(driverIds);
//
////    List<Booking> bookings=bookingRepository.findAllByDriverIn(drivers);  custom query to solve n+1 problem.
//
//    for(Driver driver : drivers){
//        List<Booking> bookings = driver.getBookings();
//        bookings.forEach(booking -> System.out.println(booking.getId()));
//
//    }
//
//
//    List<Review> reviews =reviewRepository.findAllByRatingIsLessThanEqual(6);

//    Optional<Review> r=reviewRepository.findById(1L);
//   Review r=reviewRepository.findReviewByBookingId(4L);
//
//    System.out.println(r);
//
//
//
//}
//}

