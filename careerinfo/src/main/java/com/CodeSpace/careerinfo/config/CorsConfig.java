package com.CodeSpace.careerinfo.config;

<<<<<<< HEAD
import java.util.Arrays;
=======
>>>>>>> b01a9eb6e37ec492f51695419dc7f7563fb7cbcd
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> b01a9eb6e37ec492f51695419dc7f7563fb7cbcd
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
<<<<<<< HEAD
        CorsConfiguration config = new CorsConfiguration();

        // Remove trailing slash!
        config.setAllowedOrigins(Arrays.asList(
                "https://careerinfoweb.onrender.com",
                "http://localhost:5173"  // For local development
        ));

        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowCredentials(true);
        config.setMaxAge(3600L); // Cache preflight response for 1 hour

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
=======

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(List.of("http://localhost:5173","https://careerinfoweb.onrender.com"));
        config.setAllowedMethods(List.of("GET", "POST","PATCH", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

>>>>>>> b01a9eb6e37ec492f51695419dc7f7563fb7cbcd
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> b01a9eb6e37ec492f51695419dc7f7563fb7cbcd
