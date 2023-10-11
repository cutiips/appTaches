package app;

import business.Task;
import service.TaskService;


import java.util.List;
import java.util.Scanner;

public class TaskInput {
    public void userInput (TaskService taskServiceIN, List<Task> tasksIN){
        Scanner input = new Scanner(System.in);
        int userInt = input.nextInt()-1;

        Task taskToComplete = tasksIN.get(userInt);
        taskServiceIN.markTaskAsCompleted(taskToComplete);

        System.out.println("Tâche marquée comme terminée : " + taskToComplete.getDescription());
    }
}
