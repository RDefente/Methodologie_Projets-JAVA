package task;

import history.History;
import menu.Menu;

import java.util.ArrayList;

/**
 * class List, used for representing lists of tasks
 */
public class List{
    private ArrayList<Task> tasks;
    private String name;
    private int maxTasks;
    private History history;
    private Menu menu;

    public List(String name, int maxTasks){
        this.name = name;
        this.maxTasks = maxTasks;
        this.history = null;

        this.menu = new Menu();

        this.tasks = new ArrayList<>();
    }

    /**
     * method used for adding a task to the list of tasks of this list
     * @param task : the task to be added ot the list
     */
    public void addTask(Task task){
        String historyEntry;

        this.tasks.add(task);

        historyEntry = "- added task " + task.getName();

        this.history.newEntry(historyEntry);
    }

    /**
     * method used for updating, and therefore go to the next version, of a task in this list
     * @param task : the task to be updated
     */
    public void updateTask(Task task){
        String historyEntry;

        this.removeTask(task);
        Task updatedTask = new Task("new desc for " + task.getName(), task);
        this.addTask(updatedTask);

        historyEntry = "- updated task " + updatedTask.getName();

        this.history.newEntry(historyEntry);
    }

    /**
     * method used to remove a task from the list
     * @param task : the task to be removed
     */
    public void removeTask(Task task){
        String historyEntry;

        this.tasks.remove(task);
        task.markDone();

        historyEntry = "- removed task " + task.getName();

        this.history.newEntry(historyEntry);
    }

    /**
     * method used to link a history to the list, making it the place where all changes are written
     * @param history : the history to link to this list
     */
    public void linkHistory(History history){
        this.history = history;
    }

    /**
     * method used for simply modifying some values of a task, typically the name or description
     * @param task the task to modify
     * @param list the list of which it is part
     */
    public void modifyTask(Task task, List list){
        String historyEntry;

        menu.taskModifMenu(task);

        historyEntry = "- modified " + task.getName();

        this.history.newEntry(historyEntry);
    }

    /**
     * method used for displaying the items in this list
     */
    public void displayList(){
        System.out.println("Items in " + this.name + " :\n");

        for(Task task : this.tasks){
            System.out.println(task.toString() + "\n");
        }

    }

    /**
     * method used for accessing the tasks in this list
     * @return the tasks in this list
     */
    public ArrayList<Task> getTasks(){
        return this.tasks;
    }

    /**
     * method used for returning the history used by this list
     * @return the history used by this list
     */
    public History getHistory(){
        return this.history;
    }
}
