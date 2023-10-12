package app;

import ConsoleMenu.ConsoleMenu;
import business.Task;
import service.ServiceException;
import service.TaskService;
import service.TaskServiceImpl;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        TaskService taskService = new TaskServiceImpl();

        List<Task> tasks = taskService.getAllTasks();

        TaskView taskView = new TaskView();

        TaskInput taskInput = new TaskInput();


        ConsoleMenu menu = new ConsoleMenu();
        menu.addItem("Ajouter une tâche");
        menu.addItem("Marquer une tâche comme terminée");
        menu.addItem("Supprimer une tâche terminée");
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
                 *
                 * @param taskService, service de gestion des tâches
                 * @param tasks, liste des tâches disponibles
                 */
                case 2:
                    try {
                        taskInput.userInput(taskService, tasks);
                    } catch (ServiceException e) {
                        System.out.println("Erreur : "+e.getMessage());
                    }
                    break;

                /**
                 * 3. Permet de supprimer seulement une tâche terminée
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
