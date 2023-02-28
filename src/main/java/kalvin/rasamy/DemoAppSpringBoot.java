package kalvin.rasamy;

import kalvin.rasamy.entities.Car;
import kalvin.rasamy.services.CarServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class DemoAppSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(DemoAppSpringBoot.class, args);
    }

    @Configuration
    public class CorsConfig {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/api/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
                }
            };
        }
    }


}
