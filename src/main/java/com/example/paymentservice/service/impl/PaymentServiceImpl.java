package com.example.paymentservice.service.impl;

import com.example.paymentservice.service.PaymentService;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Observed(name = "paymentService")
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void startPayment() {
        log.info("Payment Done.");
    }
}
