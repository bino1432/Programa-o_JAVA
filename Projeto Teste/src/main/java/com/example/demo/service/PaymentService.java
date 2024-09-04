package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public enum PaymentStatus {
        SUCCESS, FAILURE
    }

}
