package com.siddharth.config;

import com.siddharth.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //  @Bean(name = "com2")
    //  @Bean(name = {"com2", "desktop1"}) // can give multiple names
    @Bean
    public Desktop desktop() { // function name is default bean name
        return new Desktop(); // we are just asking spring to do this
    }
}
