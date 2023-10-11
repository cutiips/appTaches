package app;

import ConsoleMenu.ConsoleMenu;
import business.Task;
import service.TaskService;
import service.TaskServiceImpl;
import app.TaskView;

import java.util.List;
import java.util.Scanner;


public class test {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            TaskService taskService = new TaskServiceImpl();

            List<Task> tasks = taskService.getAllTasks();

            TaskView taskView = new TaskView();


            ConsoleMenu menu = new ConsoleMenu();
            menu.addItem("Ajouter une tâche");
            menu.addItem("Marquer une tâche comme terminée");
            menu.addItem("Supprimer une tâche");
            menu.addItem("Afficher toutes les tâches");
            menu.addItem("Quitter");

            while (true) {
                int choice = menu.displayAndGetChoice();

                switch (choice) {
                    /**
                     * 1. Permet l'ajout d'une nouvelle tâche
                     */
                    case 1:
                        String userStr = input.nextLine();
                        taskService.addTask(userStr);
                        break;
                    /**
                     * 2. Permet de notifier une tâche comme terminée
                     */
                    case 2:
                        int userInt = input.nextInt()-1;
                        Task taskToComplete = tasks.get(userInt);
                        taskService.markTaskAsCompleted(taskToComplete);

                        System.out.println("Tâche marquée comme terminée : " + taskToComplete.getDescription());
                        break;
                    /**
                     * 3. Permet de supprimer une tâche terminée
                     */
                    case 3:
                        taskService.removeCompletedTasks();
                        break;

                    /**
                     * 4. Permet d'afficher toutes les tâches
                     */
                    case 4:
                        System.out.println(taskView.displayTasks(taskService.getAllTasks()));
                        break;
                    /**
                     * Permet de quitter l'application
                     */
                    case 5:
                        System.out.println("Au revoir !");
                        System.exit(0);
                    default:
                        System.out.println("Option non valide.");

            }
        }
    }

}
