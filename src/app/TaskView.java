package app;

import java.util.List;
import business.Task;

/**
 * Classe pour afficher la liste des tâches sous forme de String
 */

public class TaskView {

    /**
     * Affiche la liste des tâches sous forme de String
     * @param tasks, la liste des tâches à afficher
     * @return, une String représentant la liste des tâches
     */
    public String displayTasks (List<Task> tasks){

        int index = 1;
        String str = "--------------------";
        str += "\nListe des tâches :";

        for (Task task : tasks) {
            str += "\n" + (index+++". ")+ (task);
        }
        str += "\n -------------------- ";

        return str;
    }
}
