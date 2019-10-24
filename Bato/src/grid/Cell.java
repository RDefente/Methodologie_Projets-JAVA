package grid;

import ship.*;

public class Cell {

	private int xCoord, yCoord;
	private boolean hasShip, hidden;
	private Ship ship;
	
	public Cell(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.ship = null;
		this.hasShip = false;
		this.hidden = true;
	}
	
	public boolean hasShip() {
		return hasShip;
	}

	public void placeShip(Ship ship){
		this.hasShip = true;
		this.ship = ship;
	}
	
	public boolean isHidden() {
		return hidden;
	}

	public String toString(){
		if(this.hidden){
			return " ? ";
		}else {
			if (this.hasShip) {
				return " S ";
			} else {
				return " ~ ";
			}
		}
	}

	public void reveal(){
		this.hidden = false;
		if(this.hasShip){
            this.ship.removeCell(this);
        }
	}

	public boolean outOfBounds(int xBound, int yBound){
		return (this.xCoord >= xBound || this.yCoord >= yBound);
	}

}
