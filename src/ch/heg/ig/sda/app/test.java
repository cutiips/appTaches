package ch.heg.ig.sda.app;

import ConsoleMenu.ConsoleMenu;
import ch.heg.ig.sda.business.RecurringTask;
import ch.heg.ig.sda.business.Task;
import ch.heg.ig.sda.service.ServiceException;
import ch.heg.ig.sda.service.ITaskService;
import ch.heg.ig.sda.service.TaskServiceImpl;

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
                     * @param taskService, ch.heg.ig.sda.service de gestion des tâches
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
                     * 5. Permet de tester la classe RecurringTask
                     * Pour le moment cette classe n'est pas utilisée dans le programme car elle n'est pas complètement fonctionnelle
                     */

                    case 5 :
                        RecurringTask recurringTask = new RecurringTask("test", 7);

                        recurringTask.markAsCompleted();

                        tasks.add(recurringTask);

                        System.out.println("Tâche récurrente terminée : "+recurringTask.isCompleted());
                        break;

                    /**
                     * 6. Permet de quitter l'application
                     */
                    case 6:
                        System.out.println("Au revoir !");
                        System.exit(0);
                    default:
                        System.out.println("Option non valide.");

            }
        }
    }

}
