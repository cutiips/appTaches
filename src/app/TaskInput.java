package app;

import business.Task;
import service.ServiceException;
import service.TaskService;


import java.util.List;
import java.util.Scanner;

public class TaskInput {
    public void userInput (TaskService taskServiceIN, List<Task> tasksIN) throws ServiceException {
        Scanner input = new Scanner(System.in);
        int userInt = input.nextInt()-1;

        try {
            if (userInt < 0 || userInt >= tasksIN.size()){
                throw new ServiceException("Tâche invalide");
            }

            Task taskToComplete = tasksIN.get(userInt);
            taskServiceIN.markTaskAsCompleted(taskToComplete);

            System.out.println("Tâche marquée comme terminée : " + taskToComplete.getDescription());
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }
}
