package com.siddharth.config;

import com.siddharth.Alien;
import com.siddharth.Computer;
import com.siddharth.Desktop;
import com.siddharth.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.siddharth")
public class AppConfig {

    /*@Bean
    public Alien alien1() {
        Alien obj = new Alien();
        obj.setAge(25);
        obj.setComputer(desktop());
        return obj;
    }

    // if you don't want to set object tightly coupled with just desktop but also want laptop to access
    @Bean
    public Alien alien2(Computer com) {
        Alien obj = new Alien();
        obj.setAge(25);
        obj.setComputer(com);
        return obj;
    }

    // Older versions -> need to specify @Autowired explicitly
    @Bean
    public Alien alien3(@Autowired Computer com) {
        Alien obj = new Alien();
        obj.setAge(25);
        obj.setComputer(com);
        return obj;
    }*/

    /*@Bean
    public Alien alien(@Qualifier("desktop") Computer com) { // @Qualifier = ref
        Alien obj = new Alien();
        obj.setAge(25);
        obj.setComputer(com);
        return obj;
    }*/

    /*@Bean
    public Alien alien(Computer com) {
        Alien obj = new Alien();
        obj.setAge(25);
        obj.setComputer(com);
        return obj;
    }

    //  @Bean(name = "com2")
    //  @Bean(name = {"com2", "desktop1"}) // can give multiple names
    @Bean
    //  @Scope("prototype") // setting scope
    public Desktop desktop() { // function name is default bean name
        return new Desktop(); // we are just asking spring to do this
    }

    @Bean
    @Primary
    public Laptop laptop() {
        return new Laptop();
    }*/
}
