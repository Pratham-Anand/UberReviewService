package com.example.uberreviewservice.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private String content;   //tells which column to show in response.
    private Double rating;
    private Long booking;
    private Date createdAt;
    private Date updatedAt;


}