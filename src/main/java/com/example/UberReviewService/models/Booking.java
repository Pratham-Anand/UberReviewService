package com.example.UberReviewService.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking extends BaseModel{

    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private Review review;  //one to one relation between booking and review;

    @Enumerated(value= EnumType.STRING)
    private BookingStatus bookingstatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private  Date endTime;

    private Long TotalDistance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;

}
