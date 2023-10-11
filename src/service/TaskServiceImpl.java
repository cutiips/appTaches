package service;

import business.Task;
import business.TaskManager;

import java.util.List;

/**
 * Implémentation de l'interface TaskService qui fournit des opérations
 * de gestion des tâches en utilisant TaskManager.
 */
public class TaskServiceImpl implements TaskService {
    private TaskManager taskManager;

    /**
     * Constructeur de la classe TaskServiceImpl.
     * Initialise un gestionnaire de tâches.
     */
    public TaskServiceImpl() {
        taskManager = new TaskManager();
    }

    /**
     * Ajoute une nouvelle tâche avec la description spécifiée.
     *
     * @param description La description de la tâche à ajouter.
     */
    @Override
    public void addTask(String description) {
        Task task = new Task(description);
        taskManager.addTask(task);
    }

    /**
     * Récupère la liste de toutes les tâches existantes.
     *
     * @return La liste de toutes les tâches.
     */
    @Override
    public List<Task> getAllTasks() {
        return taskManager.getAllTasks();
    }

    /**
     * Marque une tâche spécifique comme terminée.
     *
     * @param task La tâche à marquer comme terminée.
     */
    @Override
    public void markTaskAsCompleted(Task task) {
        taskManager.markTaskAsCompleted(task);
    }

    /**
     * Supprime toutes les tâches marquées comme terminées de la liste.
     */
    @Override
    public void removeCompletedTasks() {
        taskManager.removeCompletedTasks();
    }
}
