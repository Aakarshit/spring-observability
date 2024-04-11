package com.example.paymentservice.configuration;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.ObservationTextPublisher;
import io.micrometer.observation.aop.ObservedAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ServerHttpObservationFilter;

@Configuration
@Slf4j
public class ObservedAspectConfiguration {

    @Bean
    public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        observationRegistry
                .observationConfig()
                .observationHandler(new ObservationTextPublisher(log::info));;
        return new ObservedAspect(observationRegistry);
    }

    @Bean
    public ServerHttpObservationFilter observationFilter(ObservationRegistry registry) {
        return new ServerHttpObservationFilter(registry);
    }
}