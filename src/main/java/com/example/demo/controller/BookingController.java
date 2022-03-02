package com.example.demo.controller;

import com.example.demo.entity.request.BookingRequest;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class BookingController {
    @Autowired
    private final BookingService bookingService;

    @PostMapping("booking")
    public ResponseEntity<String> createBooking(@RequestBody @Valid BookingRequest bookingRequest) {
        bookingService.mappingRequestToBooking(bookingRequest);

            return new ResponseEntity<>("booking created", HttpStatus.OK);
        }
    }

