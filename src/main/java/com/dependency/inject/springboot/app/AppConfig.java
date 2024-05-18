package com.dependency.inject.springboot.app;

import com.dependency.inject.springboot.app.repositories.ProductRepository;
import com.dependency.inject.springboot.app.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean("productJson")
    ProductRepository productRepositoryJson() throws IOException {
        return new ProductRepositoryJson();
    }

}
