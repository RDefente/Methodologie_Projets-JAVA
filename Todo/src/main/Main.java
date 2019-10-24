package main;

import history.History;
import menu.Menu;
import task.List;

public class Main {
    public static void main(String[] args){

        Menu menu = new Menu();
        List list = new List("My list", 100);
        History history = new History();

        list.linkHistory(history);

        while(true){
            menu.listChoiceMenu(list);
        }

    }
}
