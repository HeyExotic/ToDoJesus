package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class TodoListTest {
    private ToDoTestt todotestt;

    @BeforeEach
    void setUp() {
        todotestt = new ToDoTestt();
    }

    @Test
    void testAddTask() {
        todotestt.addTask("Go to the gym");
        assertEquals(1, todotestt.AllTasksTest().size());
        assertEquals("Go to the gym", todotestt.AllTasksTest().get(0).getTaskName());
    }

    @Test
    void testRemoveTask() {
        todotestt.addTask("Go to the gym");
        todotestt.addTask("Drive the car");
        todotestt.removeTask(0);
        assertEquals(1, todotestt.AllTasksTest().size());
        assertEquals("Drive the car", todotestt.AllTasksTest().get(0).getTaskName());
    }

    @Test
    void testMarkTaskComplete() {
        todotestt.addTask("Go to the gym");
        todotestt.CompleteTest(0);
        assertTrue(todotestt.AllTasksTest().get(0).TestComplete());
    }

    @Test
    void testGetCompleteTasks() {
        todotestt.addTask("Go to the gym");
        todotestt.addTask("Drive the car");
        todotestt.CompleteTest(0);
        List<Task> completeTasks = todotestt.getCompleteTasks();
        assertEquals(1, completeTasks.size());
        assertEquals("Go to the gym", completeTasks.get(0).getTaskName());
    }

    @Test
    void testGetIncompleteTasks() {
      todotestt.addTask("Go to the gym");
      todotestt.addTask("Drive the car");
      todotestt.CompleteTest(0);
        List<Task> incompleteTasks = todotestt.getIncompleteTasks();
        assertEquals(1, incompleteTasks.size());
        assertEquals("Drive the car", incompleteTasks.get(0).getTaskName());
    }

    @Test
    void testClearTasks() {
      todotestt.addTask("Go to the gym");
      todotestt.addTask("Drive the car");
      todotestt.clearTasks();
        assertEquals(0, todotestt.AllTasksTest().size());
    }
}
