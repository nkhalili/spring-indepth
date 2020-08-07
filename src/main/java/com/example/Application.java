package com.example;

import com.example.service.GreetingService;
import com.example.service.OutputService;
import com.example.service.TimeService;

public class Application {
    public static void main(String[] args) throws Exception {
        GreetingService greetingService = new GreetingService("Hello");
        TimeService timeService = new TimeService(true);
        OutputService outputService = new OutputService(greetingService, timeService);

        for (int i=0;i<5;i++){
            outputService.generateOutput("Frank");
            Thread.sleep(5000);
        }
    }
}
