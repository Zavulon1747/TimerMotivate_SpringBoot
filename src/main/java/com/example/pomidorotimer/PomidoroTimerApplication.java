package com.example.pomidorotimer;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PomidoroTimerApplication {



    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PomidoroTimerApplication.class);

        PomidoroTimer pomidoroTimer = context.getBean(PomidoroTimer.class);
    }

}
