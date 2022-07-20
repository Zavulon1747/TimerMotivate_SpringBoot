package com.example.pomidorotimer.Repository;

import com.example.pomidorotimer.Entity.PomodoroTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PomodoroTimerRepository extends JpaRepository<PomodoroTask, Integer> {


}

