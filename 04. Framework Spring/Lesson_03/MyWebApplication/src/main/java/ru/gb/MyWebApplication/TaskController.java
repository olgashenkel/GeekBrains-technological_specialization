package ru.gb.MyWebApplication;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Метод для получения всех задач
    @GetMapping
    public List<Task> getAllTask() {
        return taskService.getAllTasks();
    }

    // Метод для получения задач по ID
    @GetMapping("{id}")
    public Task getById(@PathVariable UUID id) {
        return taskService.getTask(id);
    }

    // Метод для добавления новой задачи
    @PostMapping()
    public Task addById(@RequestBody Task task) {
        return taskService.addTask(task);
    }


    // Метод обновления задач по ID
    @PutMapping ("put/{id}")
    public Task putById(@PathVariable UUID id, Task task) {
        return taskService.updateTask(id, task);
    }


    // Метод для удаления задач по ID
    @DeleteMapping ("delete/{id}")
    public void deleteById(@PathVariable UUID id) {
        taskService.deleteTask(id);
    }


}
