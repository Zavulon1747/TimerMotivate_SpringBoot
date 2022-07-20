package com.example.pomidorotimer.Repository;

import com.example.pomidorotimer.Entity.PomodoroTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PomodoroTimerRepository extends CrudRepository<PomodoroTask, Integer> {

    void addDescription(String description);
}

