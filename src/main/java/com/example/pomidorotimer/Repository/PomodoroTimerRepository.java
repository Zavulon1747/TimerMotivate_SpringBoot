package com.example.pomidorotimer.Repository;

import com.example.pomidorotimer.Entity.PomodoroTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

public interface PomodoroTimerRepository extends CrudRepository<PomodoroTask, Integer> {

    PomodoroTask findByDate_of_done(LocalDateTime date_of_done);
}

