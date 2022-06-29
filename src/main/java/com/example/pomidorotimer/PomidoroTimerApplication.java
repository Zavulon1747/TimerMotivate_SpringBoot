package com.example.pomidorotimer;

import com.example.pomidorotimer.Repository.PomidoroTimerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PomidoroTimerApplication {



    public static void main(String[] args) {
        new PomidoroTimer().timer(0, 0, 0);
    }

}
