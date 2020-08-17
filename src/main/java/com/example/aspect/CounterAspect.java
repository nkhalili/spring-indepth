package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class CounterAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    private static final Map<String, Integer> counterMap = new HashMap();

    @Pointcut("execution(* *(..))")
    public void execute(){ }

    @Before(value="execute()")
    public void reportMethodCalls(JoinPoint joinPoint) {
        StringBuilder message = new StringBuilder("Method name: ");
        String methodName = joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName();

        if(counterMap.containsKey(methodName)){
            int current = counterMap.get(methodName);
            current++;
            counterMap.put(methodName, current);
        } else{
            counterMap.put(methodName, 1);
        }

        counterMap.forEach((k,v)->{
            message.append(k + " called " + v + " time(s) | ");
        });

        LOGGER.info(message.toString());
    }
}
