package history;

import java.util.ArrayList;

public class History {
    private int linesToPrint = 20;
    private ArrayList<String> entries;

    public History(){
        this.entries = new ArrayList<>();
    }

    public History(int maxLines){
        this.linesToPrint = maxLines;
        this.entries = new ArrayList<>();
    }

    public void newEntry(String entry){
        this.entries.add(entry);
    }

    public void display(){
        System.out.println("History :\n");

        for(String entry : this.entries){
            System.out.println(entry + "\n");
        }

    }
}
