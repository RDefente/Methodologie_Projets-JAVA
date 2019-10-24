package main;

import ship.*;
import grid.*;
import util.strategy.PlacementStrategy;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Player firstPlayer;
    private Player secondPlayer;

    public Game(Player p1, Player p2){
        this.firstPlayer = p1;
        this.secondPlayer = p2;
    }

    public boolean over(){
        if(this.firstPlayer.lost()) System.out.println(this.secondPlayer.getName() + " has won!");
        else if(this.secondPlayer.lost()){
            System.out.println(this.firstPlayer.getName() + " has won!");
        }
        return (this.firstPlayer.lost() || this.secondPlayer.lost());
    }

    public void turn(Scanner sc, Player player, Player opponent){
        firstPlayer.displayGrid();
        secondPlayer.displayGrid();

        int x, y;

        System.out.println(player.getName() + "'s turn : drop that bomb!");

        Cell target = null;

        while(target == null || !target.isHidden()){

            System.out.println("Latitude : ");
            x = sc.nextInt();

            System.out.println("Longitude : ");
            y = sc.nextInt();

            target = opponent.getGrid().getCell(x, y);

            if(!target.isHidden()) System.out.println("Bombing the same place is not an efficient strategy...");
        }

        player.shootCell(target);
    }

    public void placePlayerShips(){

        PlacementStrategy plStratPl1 = this.firstPlayer.getPlacementStrategy();
        PlacementStrategy plStratPl2 = this.secondPlayer.getPlacementStrategy();

        plStratPl1.placeShips(this.firstPlayer);
        plStratPl2.placeShips(this.secondPlayer);

    }
}
