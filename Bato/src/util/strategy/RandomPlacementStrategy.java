package util.strategy;

import exception.InvalidPlacementException;
import grid.Grid;
import main.Player;
import ship.Ship;

import java.util.ArrayList;

public class RandomPlacementStrategy implements PlacementStrategy{

    public void placeShips(Player player){

        Grid playerGrid = player.getGrid();
        ArrayList<Ship> ships = player.getShips();
        ArrayList<Ship> shipsAdded = new ArrayList<>();

        int i = 0;

        while(!(shipsAdded.containsAll(ships))) {

            Ship ship = ships.get(i);

            int randomX = (int) (Math.random()*playerGrid.getxBound()-1);
            int randomY = (int) (Math.random()*playerGrid.getyBound()-1);

            try{
                boolean res = playerGrid.addShip(ship, randomX, randomY);

                if(res) {
                    shipsAdded.add(ship);
                }
            }catch(InvalidPlacementException e){
                System.out.println(e.getMessage());
            }

            i++;
        }
    }
}
