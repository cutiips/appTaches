package app;

import java.util.List;
import business.Task;
import service.TaskService;
import service.TaskServiceImpl;


public class TaskView {
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
