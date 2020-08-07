package com.example.config;

import com.example.service.GreetingService;
import com.example.service.OutputService;
import com.example.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    @Value("${app.greeting}")
    private String greeting;
    @Value("${app.name}")
    private String name;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private TimeService timeService;

    @Bean
    public TimeService timeService(){
        return new TimeService(true);
    }

    @Bean
    public OutputService outputService(){
        return new OutputService(this.greetingService, this.timeService, this.name);
    }

    @Bean
    public GreetingService greetingService(){
        return new GreetingService(this.greeting);
    }
}
