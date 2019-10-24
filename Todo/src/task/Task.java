package task;

import java.util.ArrayList;

public class Task {
    private enum State {WIP, DONE}

    private State state;
    private String name;
    private String desc;
    private int version;
    private ArrayList<Task> archive;

    public Task(String name, String desc){
        this.name = name;
        this.desc = desc;

        this.state = State.WIP;

        this.version = 1;

        this.archive = new ArrayList<>();
    }

    public Task(String desc, Task oldTask){
        this.name = oldTask.getName();
        this.desc = desc;

        this.state = State.WIP;

        this.version = oldTask.getVersion() + 1;

        this.archive = oldTask.getArchive();
        this.archive.add(oldTask);
    }

    public void markDone(){
        this.state = State.DONE;
        this.archive.add(this);
    }

    public int getVersion(){
        return this.version;
    }

    public String getDesc(){
        return this.desc;
    }

    public String getName(){
        return this.name;
    }

    public State getState(){
        return this.state;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public ArrayList<Task> getArchive(){
        return this.archive;
    }

    @Override
    public String toString(){
        String res = "";

        res += (this.getName() + " (v" + this.getVersion() + ") :\n");
        res += (this.getDesc() + "\n");
        res += ("Ancienne versions : " + this.archive.size());

        return res;
    }
}
