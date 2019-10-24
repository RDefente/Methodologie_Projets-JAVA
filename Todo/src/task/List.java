package task;

import history.History;
import menu.Menu;

import java.util.ArrayList;

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

    public void addTask(Task task){
        String historyEntry;

        this.tasks.add(task);

        historyEntry = "- added task " + task.getName();

        this.history.newEntry(historyEntry);
    }

    public void updateTask(Task task){
        String historyEntry;

        this.removeTask(task);
        Task updatedTask = new Task("new desc for " + task.getName(), task);
        this.addTask(updatedTask);

        historyEntry = "- updated task " + updatedTask.getName();

        this.history.newEntry(historyEntry);
    }

    public void removeTask(Task task){
        String historyEntry;

        this.tasks.remove(task);
        task.markDone();

        historyEntry = "- removed task " + task.getName();

        this.history.newEntry(historyEntry);
    }

    public void linkHistory(History history){
        this.history = history;
    }

    public void modifyTask(Task task, List list){
        String historyEntry;

        menu.taskModifMenu(task, list);

        historyEntry = "- modified " + task.getName();

        this.history.newEntry(historyEntry);
    }

    public void displayList(){
        System.out.println("Items in " + this.name + " :\n");

        for(Task task : this.tasks){
            System.out.println(task.toString() + "\n");
        }

    }

    public ArrayList<Task> getTasks(){
        return this.tasks;
    }

    public History getHistory(){
        return this.history;
    }
}
