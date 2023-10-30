package java.sda.app;

import ConsoleMenu.ConsoleMenu;

import java.sda.business.RecurringTask;
import java.sda.business.Task;
import java.sda.service.ITaskService;
import java.sda.service.TaskServiceImpl;
import java.util.List;
import java.util.Scanner;


public class test {
        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);

            ITaskService taskService = new TaskServiceImpl();

            List<Task> tasks = taskService.getAllTasks();

            TaskView taskView = new TaskView();

            TaskInput taskInput = new TaskInput();


            ConsoleMenu menu = new ConsoleMenu();
            menu.addItem("Ajouter une tâche");
            menu.addItem("Marquer une tâche comme terminée");
            menu.addItem("Supprimer une tâche");
            menu.addItem("Afficher toutes les tâches");
            menu.addItem("Test : Ajouter une récurrence");
            menu.addItem("Quitter");

            while (true) {
                int choice = menu.displayAndGetChoice();

                switch (choice) {
                    case 1:
                        String userStr = input.nextLine();
                        taskService.addTask(userStr);
                        break;

                    case 2:
                        taskInput.userInput(taskService, tasks);

                        break;

                    case 3:
                        taskService.removeCompletedTasks();
                        break;

                    case 4:
                        System.out.println(taskView.displayTasks(taskService.getAllTasks()));
                        break;

                    case 5 :
                        RecurringTask recurringTask = new RecurringTask("test", 7);

                        recurringTask.markAsCompleted();

                        tasks.add(recurringTask);

                        System.out.println("Tâche récurrente terminée : "+recurringTask.isCompleted());
                        break;

                    case 6:
                        System.out.println("Au revoir !");
                        System.exit(0);
                    default:
                        System.out.println("Option non valide.");
            }
        }
    }
}
