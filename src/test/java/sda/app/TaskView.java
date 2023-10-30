package java.sda.app;

import java.sda.business.Task;
import java.util.List;

/**
 * Classe pour afficher la liste des tâches sous forme de String
 */

public class TaskView {

    /**
     * Affiche la liste des tâches sous forme de String
     *
     * @param tasks, la liste des tâches à afficher
     * @return, une String représentant la liste des tâches
     */
    public String displayTasks (List<Task> tasks){

        int index = 1;
        StringBuilder str = new StringBuilder("--------------------");
        str.append("\nListe des tâches :");

        for (Task task : tasks) {
            str.append("\n").append(index++).append(". ").append(task);
        }
        str.append("\n -------------------- ");

        return str.toString();
    }
}