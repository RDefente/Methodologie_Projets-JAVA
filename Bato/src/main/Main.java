package main;

import ship.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		System.out.println("+---------------------+");
		System.out.println("| B A T T L E S H I P |");
		System.out.println("+---------------------+");

		Player jc = new Player("Jean-Claude");
		Player jj = new Player("Jean-Jacques");

		Game game = new Game(jc, jj);

		Ship ship = new Ship(3, "H");
		Ship ship2 = new Ship(4, "V");
        Ship ship3 = new Ship(2, "H");
        Ship ship4 = new Ship(1, "V");

        jj.addShip(ship);
        jj.addShip(ship2);

        jc.addShip(ship3);
        jc.addShip(ship4);

		game.placePlayerShips();

		Scanner sc = new Scanner(System.in);

		while(!game.over()){
		    game.turn(sc, jc, jj);
		    game.turn(sc, jj, jc);
		}

	}

}
