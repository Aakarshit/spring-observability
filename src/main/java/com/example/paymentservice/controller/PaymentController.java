package com.example.paymentservice.controller;

import com.example.paymentservice.service.PaymentService;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Observed(name = "paymentController")
@RequestMapping("/payment")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/start-payment")
    @Observed(name = "startPayment")
    public ResponseEntity<String> startPayment(){
        log.info("Payment Started.");
        paymentService.startPayment();
        log.info("Payment Completed.");
        return ResponseEntity.ok("SUCCESS");
    }
}