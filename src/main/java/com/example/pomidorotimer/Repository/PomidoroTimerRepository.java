package com.example.pomidorotimer.Repository;

import com.example.pomidorotimer.Entity.PomidoroTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PomidoroTimerRepository extends JpaRepository<PomidoroTask, Integer> {


}

