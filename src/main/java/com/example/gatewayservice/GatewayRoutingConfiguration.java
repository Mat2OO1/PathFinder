package com.example.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutingConfiguration {

    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("gallery-service", r -> r.path("/gallery/**").uri("lb://gallery-service")) // dynamic redirect to different instance of microservice
                .route("image-service", r -> r.path("/images/**").uri("http://localhost:8200")) // static
                .build();
    }
}

