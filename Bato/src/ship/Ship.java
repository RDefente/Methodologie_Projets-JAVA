package ship;

import java.util.*;
import grid.*;

public class Ship {

	public enum State {ATTACKED, INTACT, DESTROYED}

	private int length;
	private String direction;
	private State state;
	private Set<Cell> occupiedCells;
	
	public Ship(int length, String direction) {
		this.length = length;
		this.direction = direction;

		this.state = State.INTACT;

		this.occupiedCells = new HashSet<>();
	}

	public void addOccupiedCell(Cell cell){
		this.occupiedCells.add(cell);
	}


	public State getState(){
		if(occupiedCells.isEmpty()){
			this.state = State.DESTROYED;
		}else if(this.occupiedCells.size() == this.length){
			this.state = State.INTACT;
		}else{
			this.state = State.ATTACKED;
		}

		return this.state;
	}

	public void removeCell(Cell cell){
		this.occupiedCells.remove(cell);
	}

	public String getDirection(){
		return this.direction;
	}

	public int getLength(){
		return this.length;
	}


	
}
