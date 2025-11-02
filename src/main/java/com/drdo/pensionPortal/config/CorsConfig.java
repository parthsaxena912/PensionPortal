package com.drdo.pensionPortal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // ✅ Railway requires wildcard pattern support
        config.addAllowedOriginPattern("http://localhost:4200");
        config.addAllowedOriginPattern("https://dodo-frontendvercel.vercel.app");
        config.addAllowedOriginPattern("*");  // ✅ Allow all (required on Railway)

        // ✅ Allow all headers
        config.addAllowedHeader("*");

        // ✅ Allow all HTTP methods including OPTIONS
        config.addAllowedMethod("*");

        // ✅ Allow credentials
        config.setAllowCredentials(true);

        // ✅ Apply to all routes
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
