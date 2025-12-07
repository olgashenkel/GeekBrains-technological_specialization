package ru.gb.MyWebApplication;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Task {
    public enum Status{
        TO_DO,
        IN_PROGRESS,
        DONE
    }

    private UUID id;
    private String name;
    private String description;
    private Status status;
    private LocalDateTime completionTime;

    public Task(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }


}
