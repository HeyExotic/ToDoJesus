package org.example;

import java.util.ArrayList;
import java.util.List;

class Task {
    private String nameTest;
    private boolean CompleteTest;

    public Task(String nameTest) {
        this.nameTest = nameTest;
        this.CompleteTest = false;
    }

    public String getDescription() {
        return nameTest;
    }

    public boolean isComplete() {
        return CompleteTest;
    }

    public void markComplete() {
        CompleteTest = true;
    }

    @Override
    public String toString() {
        return (CompleteTest ? "[Complete] " : "[Incomplete] ") + nameTest;
    }
}

public class ToDoTestt {
    private List<Task> tasks;

    public ToDoTestt() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } 
    }

    public void CompleteTest(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markComplete();
        } 
    }

    public List<Task> AllTasksTest() {
        return tasks;
    }

    public List<Task> getCompleteTasks() {
        return tasks.stream().filter(Task::isComplete).toList();
    }

    public List<Task> getIncompleteTasks() {
        return tasks.stream().filter(task -> !task.isComplete()).toList();
    }

    public void clearTasks() {
        tasks.clear();
    }
}