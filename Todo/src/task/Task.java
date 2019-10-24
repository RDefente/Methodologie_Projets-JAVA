package task;

import java.util.ArrayList;

/**
 * class Task used for representing tasks
 */
public class Task {
    /**
     * enum class State used for representing the state of a task
     */
    private enum State {WIP, DONE}

    private State state;
    private String name;
    private String desc;
    private int version;
    private ArrayList<Task> archive;

    /**
     * Constructor used when creating a brand new task
     * @param name the name of this task
     * @param desc the description of this task
     */
    public Task(String name, String desc){
        this.name = name;
        this.desc = desc;

        this.state = State.WIP;

        this.version = 1;

        this.archive = new ArrayList<>();
    }

    /**
     * Constructor used when updating a task, incrementing the version number automatically and keeping the name of the old version
     * @param desc the new description
     * @param oldTask the old version of this task
     */
    public Task(String desc, Task oldTask){
        this.name = oldTask.getName();
        this.desc = desc;

        this.state = State.WIP;

        this.version = oldTask.getVersion() + 1;

        this.archive = oldTask.getArchive();
        this.archive.add(oldTask);
    }

    /**
     * used for marking a task as finished
     */
    public void markDone(){
        this.state = State.DONE;
        this.archive.add(this);
    }

    /**
     * getter for the version number of this task
     * @return the version number of this task
     */
    public int getVersion(){
        return this.version;
    }

    /**
     * getting for the description of this task
     * @return the description of this task
     */
    public String getDesc(){
        return this.desc;
    }

    /**
     * getter for the name of this task
     * @return the name of this task
     */
    public String getName(){
        return this.name;
    }

    /**
     * setter for the name of this task
     * @param name the new name to be assigned
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * setter for the description of this task
     * @param desc the new description to be assigned to this task
     */
    public void setDesc(String desc){
        this.desc = desc;
    }

    /**
     * getter for the archives of this task, i.e. all its old versions
     * @return the ArrayList containing all older versions of this task
     */
    public ArrayList<Task> getArchive(){
        return this.archive;
    }

    /**
     * this class' toString method
     * @return the String representation of a Task object
     */
    @Override
    public String toString(){
        String res = "";

        res += (this.getName() + " (v" + this.getVersion() + ") :\n");
        res += (this.getDesc() + "\n");
        res += ("Old versions : " + this.archive.size());

        return res;
    }
}
