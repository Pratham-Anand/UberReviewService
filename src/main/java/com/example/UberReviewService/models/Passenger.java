package com.example.UberReviewService.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import  lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class Passenger extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "passenger",fetch = FetchType.LAZY)
    private List<Booking> bookings =new ArrayList<>();
}
