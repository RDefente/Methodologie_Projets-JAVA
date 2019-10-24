package main;

import java.util.*;
import ship.*;
import grid.*;
import util.strategy.PlacementStrategy;
import util.strategy.RandomPlacementStrategy;

public class Player {
	private String name;
	private ArrayList<Ship> ships;
	private Grid playerGrid;
	private PlacementStrategy shipPlacement;
	
	public Player(String name) {
		this.name = name;
		this.playerGrid = new Grid(10, 10);
		this.ships = new ArrayList<Ship>();
		this.shipPlacement = new RandomPlacementStrategy();
	}

	public void addShip(Ship ship){
		this.ships.add(ship);
	}

	public void shootCell(Cell cell){
		if(cell.hasShip()){
		    System.out.println("BOOM!");
        }else{
		    System.out.println("Plouf!");
        }
	    cell.reveal();
	}

	public String getName(){
		return this.name;
	}

	public boolean check(){
		return this.ships.isEmpty();
	}

	public Grid getGrid(){
		return this.playerGrid;
	}

	public ArrayList<Ship> getShips(){
		return this.ships;
	}

	public void displayGrid(){
		System.out.println(this.name);
		System.out.println(this.playerGrid.toString());
	}

	public String toString() {
		return "Player " + this.name + " has " + this.ships.size() + " ships left!";
	}

	public boolean lost(){
	    int i;

	    for(i = 0; i < this.ships.size(); i++){
	    	if(this.ships.get(i).getState() != Ship.State.DESTROYED) {
				return false;
			}
		}
	    return true;

    }

	public PlacementStrategy getPlacementStrategy(){
		return this.shipPlacement;
	}
	
}
