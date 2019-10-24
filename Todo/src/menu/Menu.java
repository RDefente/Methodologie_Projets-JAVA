package menu;

import task.List;
import task.Task;

import java.util.Scanner;

/**
 * class used for providing menu-like exploration in the console
 */
public class Menu {
    private Scanner sc;

    public Menu(){
        this.sc = new Scanner(System.in);
    }

    /**
     * the main menu, provides the user all of the possible choices when at the root of the project
     * @param list : the list of tasks being used by the user
     */
    public void listChoiceMenu(List list){
        String option;

        System.out.println("What do you want to do : add/remove/modify/history/display");
        option = sc.nextLine();

        switch(option){
            case "add":
                String name, desc;

                System.out.println("Let's create a task :");

                System.out.println("Enter a name :");
                name = sc.nextLine();

                System.out.println("Enter a description :");
                desc = sc.nextLine();

                Task newTask = new Task(name, desc);

                list.addTask(newTask);
                break;

            case "remove":
                int ind;

                System.out.println("Specify the index of the task to remove");
                ind = sc.nextInt();

                list.removeTask(list.getTasks().get(ind));

                break;
            case "modify":
                System.out.println("Specify the index of the task to modify");
                ind = sc.nextInt();

                Task taskToModify = list.getTasks().get(ind);



                list.modifyTask(taskToModify, list);
                break;
            case "display":
                list.displayList();
                break;
            case "history":
                list.getHistory().display();
            case "update":
                System.out.println("Specify the index of the task to update");
                ind = sc.nextInt();

                Task taskToUpdate = list.getTasks().get(ind);

                list.updateTask(taskToUpdate);
            default:
        }
    }

    /**
     * secondary menu, used for letting the user modify one of the tasks in the list
     * @param task : the task to modify
     */
    public void taskModifMenu(Task task){
        String change, option;

        System.out.println("What do you want to change : name/description");
        option = sc.nextLine();

        switch(option){
            case "name":
                System.out.println("New value for name :");
                change = sc.nextLine();
                task.setName(change);

                break;
            case "description":
                System.out.println("New value for desc :");
                change = sc.nextLine();
                task.setDesc(change);

                break;
            default:
        }
    }
}
