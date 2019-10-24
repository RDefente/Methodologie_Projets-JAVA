package history;

import java.util.ArrayList;

public class History {
    /**
     * Attributes
     * - linesToPrint : maximum lines to print on the history, unused
     * - entries : representation for the changes tracked in the history
     */
    private int linesToPrint = 20;
    private ArrayList<String> entries;

    /**
     * Constructor
     */
    public History(){
        this.entries = new ArrayList<>();
    }

    /**
     * used for adding entries to the history
     * @param entry : the line to add
     */
    public void newEntry(String entry){
        this.entries.add(entry);
    }

    /**
     * used for displaying the history in a convenient way
     */
    public void display(){
        System.out.println("History :\n");

        for(String entry : this.entries){
            System.out.println(entry + "\n");
        }

    }
}
