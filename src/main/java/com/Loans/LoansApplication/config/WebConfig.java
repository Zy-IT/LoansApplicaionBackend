package com.Loans.LoansApplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/Api/LoanApplication/**")
                .allowedOrigins("http://localhost:5173", "http://localhost:5174")
                .allowedMethods("POST","GET")
                .allowCredentials(false);

        registry.addMapping("/Api/User/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("POST","OPTIONS")
                .allowCredentials(false);
    }
}
