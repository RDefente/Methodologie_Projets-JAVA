package grid;

import exception.InvalidPlacementException;
import ship.*;

import java.util.*;

public class Grid {
	private int xBound, yBound;
	private Cell[][] grid;
	private Set<Cell> usedCells;

	
	public Grid(int xSize, int ySize) {
		this.xBound = xSize;
		this.yBound = ySize;

		this.grid = new Cell[this.yBound][this.xBound];

		this.usedCells = new HashSet<>();

		this.init();
	}
	
	private void init() {
		int i, j;
		
		for(i = 0; i < this.yBound; i++) {
			for(j = 0; j < this.xBound; j++) {
				this.grid[i][j] = new Cell(i, j);
			}
		}
	}
	
	public String toString() {
		String res = "";
		
		int i, j;
		
		for(i = 0; i < yBound; i++) {
			for(j = 0; j < xBound; j++) {
				res += this.getCell(j, i).toString();
			}
			res += "\n";
		}
		
		return res;
	}
	
	public Cell getCell(int x, int y) {
		return this.grid[x][y];
	}

	public boolean addShip(Ship ship, int x, int y) throws InvalidPlacementException {
		int i;

		Cell nextCell = null;

		ArrayList<Cell> cellsToCheck = new ArrayList<Cell>();

		int[] coords = {x, y};
		int length = ship.getLength();
		String dir = ship.getDirection();

		for(i = 0; i < length; i++){
			if(dir.equals("H")) {
				nextCell = this.getCell(coords[0] + i, coords[1]);
			}else if(dir.equals("V")) {
				nextCell = this.getCell(coords[0], coords[1] + i);
			}

			cellsToCheck.add(nextCell);
		}

		for(Cell cell : cellsToCheck){
			if(cell.hasShip() || cell.outOfBounds(this.xBound, this.yBound)){
				throw new InvalidPlacementException("Cell already has a ship or is out of bounds");
			}else{
				this.usedCells.add(cell);
				ship.addOccupiedCell(cell);
				cell.placeShip(ship);
			}
		}
		return true;
	}

	public int getyBound(){
		return this.yBound;
	}

	public int getxBound(){
		return this.xBound;
	}

}

