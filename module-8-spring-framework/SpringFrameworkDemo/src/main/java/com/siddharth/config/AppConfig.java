package com.siddharth.config;

import com.siddharth.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Desktop desktop() {
        return  new Desktop(); // we are just asking spring to do this
    }
}
