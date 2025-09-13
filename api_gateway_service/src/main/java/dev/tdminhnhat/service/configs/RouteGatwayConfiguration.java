package dev.tdminhnhat.service.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteGatwayConfiguration {

    @Bean
    public RouteLocator configureMappingRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("plane_info_service", route -> route.path("plane_info/api/v1/**").uri("lb://PLANE_INFO_SERVICE"))
                .route("schedule_service", route -> route.path("schedule/api/v1/**").uri("lb://SCHEDULE_SERVICE"))
                .route("booking_service", route -> route.path("booking/api/v1/**").uri("lb://BOOKING_SERVICE"))
                .route("review_service", route -> route.path("review/api/v1/**").uri("lb://REVIEW_SERVICE"))
                .build();
    }
}
