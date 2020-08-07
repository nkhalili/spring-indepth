package com.example;

import com.example.config.ApplicationConfig;
import com.example.service.GreetingService;
import com.example.service.OutputService;
import com.example.service.TimeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) throws Exception {
//        GreetingService greetingService = new GreetingService("Hello");
//        TimeService timeService = new TimeService(true);
//        OutputService outputService = new OutputService(greetingService, timeService);
        ApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = appContext.getBean(OutputService.class);

        for (int i=0;i<5;i++){
            outputService.generateOutput();
            Thread.sleep(5000);
        }
    }
}
