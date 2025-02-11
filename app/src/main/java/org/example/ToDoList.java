package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskCompletion {

    private String taskName;
    private boolean Completion;

    public TaskCompletion(String taskName) {
        this.taskName = taskName;
        this.Completion = false;
    }

    public String getTask() {
        return taskName;
    }

    public boolean Completion() {
        return Completion;
    }

    public void MarkComplete(){
        Completion = true;
    }

    @Override
    public String toString() {
        return (Completion ? "[Complete] " : "[Incomplete] ") + taskName;
    }
}

public class ToDoList {

    public List<TaskCompletion> tasks;
    private Scanner scanner;

    public ToDoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask(String taskName) {
        tasks.add(new TaskCompletion(taskName));
        System.out.println("Task added Succesfully: " + taskName);
    }

    public void removeTask(int taskNumber) {
        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            TaskCompletion removeTask = tasks.remove(taskNumber);
            System.out.println ("Task Removed Succesfully: " + removeTask.getTask());
        }
    }

    public void MarkComplete(int taskNumber) {
        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            TaskCompletion task = tasks.get(taskNumber);
            task.MarkComplete();
            System.out.println("Task(s) Marked Complete: " + task.getTask());
        }
    }

    public void ViewTasks() {
        System.out.println("All Tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void viewComplete() {
        List<TaskCompletion> completeTasks = tasks.stream().filter(TaskCompletion::Completion).toList();
        System.out.println("Completed Tasks: ");
        for (int i = 0; i < completeTasks.size(); i++) {
            System.out.println((i + 1) + ". " + completeTasks.get(i));
        }
    }

    public void viewIncomplete() {
        List<TaskCompletion> incompleteTasks = tasks.stream().filter(task -> !task.Completion()).toList();
        System.out.println("Incomplete Tasks: ");
        for (int i = 0; i < incompleteTasks.size(); i++) {
            System.out.println((i + 1) + ". " + incompleteTasks.get(i));
        }
    }

    public void ClearTasks() {
        tasks.clear();
        System.out.println("All Tasks Cleared");
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to Your To-Do List!");

            System.out.println("Here are Multiple Options for You, Please Pick One.");
            System.out.println("1. Add a Task");
            System.out.println("2. Remove a Task");
            System.out.println("3. Mark a Task as Complete");
            System.out.println("4. View All Tasks");
            System.out.println("5. View Complete Tasks");
            System.out.println("6. View Incomplete Tasks");
            System.out.println("7. Clear Tasks");
            System.out.println("8. End Program");
            System.out.println("\n Enter Your Option: ");    

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                System.out.println("Enter Task Name: ");
                String taskName = scanner.nextLine();
                addTask(taskName);
                break;

                case 2:
                System.out.println("Enter the task number to remove: ");
                int removeNumber = scanner.nextInt() - 1;
                removeTask(removeNumber);
                break;

                case 3:
                System.out.println("Enter task number to mark complete: ");
                int completeNumber = scanner.nextInt() - 1;
                MarkComplete(completeNumber);
                break;

                case 4:
                ViewTasks();
                break;

                case 5:
                viewComplete();
                break;

                case 6:
                viewIncomplete();
                break;

                case 7:
                ClearTasks();
                break;

                case 8:
                running = false;
                System.out.println("Thank you for using the program!");
            }
        }
        scanner.close();
    }
}