package com.example.pomidorotimer.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pomidoro_task")
public class PomidoroTask {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String description;
    @JsonFormat(pattern = "ss:mm:HH dd/MM/yyyy")
    private LocalDateTime date_of_done;

    public PomidoroTask(String description, LocalDateTime date_of_done) {
        this.description = description;
        this.date_of_done = date_of_done;
    }

    public PomidoroTask() {
    }
}
