package ru.gb.MyWebApplication;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    // Метод возвращения задачи по ID
    public Task getTask(UUID uuid) {
        return tasks.stream()
                .filter(t -> t.getId().equals(uuid))
                .findFirst().orElse(null);
    }

    // Метод добавления задачи
    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }


    // Метод удаления задачи по ID
    public void deleteTask(UUID uuid) {
        tasks.removeIf(t -> t.getId().equals(uuid));
    }

    // Метод обновления задачи по ID
    public Task updateTask (UUID uuid, Task task){
        Task task1 = getTask(uuid);
        if (task1 != null){
            task1.setDescription(task.getDescription());
            task1.setName(task.getName());
            task1.setStatus(task.getStatus());
            task1.setCompletionTime(task.getCompletionTime());
        }
        return task1;
    }

}
