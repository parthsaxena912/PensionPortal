package com.drdo.pensionPortal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // ✅ Railway requires PATTERN not fixed origins
        config.setAllowedOriginPatterns(List.of(
                "http://localhost:4200",
                "https://dodo-frontendvercel.vercel.app",
                "*"
        ));

        // ✅ Allow all headers
        config.addAllowedHeader("*");

        // ✅ Allow all HTTP methods including OPTIONS
        config.addAllowedMethod("*");

        // ✅ Allow credentials (cookies/tokens)
        config.setAllowCredentials(true);

        // ✅ Apply CORS to all API paths
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
