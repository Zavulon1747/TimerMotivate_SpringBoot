package com.example.pomidorotimer;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.pomidorotimer")
public class PomodoroTimerApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PomodoroTimerApplication.class);

        PomodoroTimer pomodoroTimer = context.getBean(PomodoroTimer.class);

        pomodoroTimer.timer(0, 0, 0);


    }

}
