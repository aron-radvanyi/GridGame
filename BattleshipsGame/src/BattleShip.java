import java.util.Random;
import javax.swing.JOptionPane;

public class BattleShip {

	private Grid theGrid = new Grid();

	private String textForDebug = "Here are the ships:";

	//method with all the ship placers 
	public void shipPlacer() {

		aircraftCarierPlacerLogic();
		battleshipPlacerLogic();
		submarinePlacerLogic();
		destroyerPlacerLogic();
		patrolBoatPlacerLogic();

	}

	// method to declare random number
	public int RandomNumGenerator() {
		Random random = new Random();
		int randomInt = random.nextInt(10);
		return randomInt + 1;
		// +1 becasue random.nextInt(10) will generate int between 0-9, and we need
		// range 1-10
	}

	//method to generate random boolean 
	public boolean randomBooleanGenerator() {
		Random random = new Random();
		boolean randomBool = random.nextBoolean();
		if (randomBool == true) {
			return true;
		} else {
			return false;
		}
	}

	// the logic to place AirCraft Carier on the grid
	public void aircraftCarierPlacerLogic() {

		Ship ship1 = new Ship(5, 2, "Aircraft Carrier");
		int startRow, startSquare, row2, row3, row4, row5, square2, square3, square4, square5;
		int aircCarierLength = 5;
		int gridLengthMax = this.theGrid.getGridLength();
		int gridlengthMin = gridLengthMax - gridLengthMax;
		boolean ifVerticalRow, verticalAllignedUp, horizontalIfAllignedLeft;

		for (int i = 0; i < 1; i++) {
			ifVerticalRow = randomBooleanGenerator();

			// if true the ship is alligned vertically
			if (ifVerticalRow == true) {
				verticalAllignedUp = randomBooleanGenerator();

				// if true the ship is alligned going up
				if (verticalAllignedUp == true) {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the top
					while (startRow - aircCarierLength < gridlengthMin) {
						startRow = RandomNumGenerator();
					}
					row2 = startRow - 1;
					row3 = startRow - 2;
					row4 = startRow - 3;
					row5 = startRow - 4;

					this.theGrid.addShipToGrid(ship1, startRow, startSquare);
					this.theGrid.addShipToGrid(ship1, row2, startSquare);
					this.theGrid.addShipToGrid(ship1, row3, startSquare);
					this.theGrid.addShipToGrid(ship1, row4, startSquare);
					this.theGrid.addShipToGrid(ship1, row5, startSquare);

					textForDebug = textForDebug + "\nAircraft Carrier: " + "(" + startRow + "," + startSquare + "),"
							+ "(" + row2 + ","
							+ startSquare + "),(" + row3 + "," + startSquare + "),(" + row4 + ","
							+ startSquare + "),(" + row5 + "," + startSquare + ")";
				}

				// else the ship is alligned going down
				else {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the bottom
					while (startRow + aircCarierLength > gridLengthMax) {
						startRow = RandomNumGenerator();
					}
					row2 = startRow + 1;
					row3 = startRow + 2;
					row4 = startRow + 3;
					row5 = startRow + 4;

					this.theGrid.addShipToGrid(ship1, startRow, startSquare);
					this.theGrid.addShipToGrid(ship1, row2, startSquare);
					this.theGrid.addShipToGrid(ship1, row3, startSquare);
					this.theGrid.addShipToGrid(ship1, row4, startSquare);
					this.theGrid.addShipToGrid(ship1, row5, startSquare);

					textForDebug = textForDebug + "\nAircraft Carrier: " + "(" + startRow + "," + startSquare + "),("
							+ row2 + ","
							+ startSquare + "),(" + row3 + "," + startSquare + "),(" + row4 + ","
							+ startSquare + "),(" + row5 + "," + startSquare + ")";
				}
			}
			// if not vertical, the ship is alligned horizontally
			else {
				horizontalIfAllignedLeft = randomBooleanGenerator();

				// the ship is alligned going left
				if (horizontalIfAllignedLeft == true) {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on left
					while (startSquare - aircCarierLength < gridlengthMin) {
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare - 1;
					square3 = startSquare - 2;
					square4 = startSquare - 3;
					square5 = startSquare - 4;

					this.theGrid.addShipToGrid(ship1, startRow, startSquare);
					this.theGrid.addShipToGrid(ship1, startRow, square2);
					this.theGrid.addShipToGrid(ship1, startRow, square3);
					this.theGrid.addShipToGrid(ship1, startRow, square4);
					this.theGrid.addShipToGrid(ship1, startRow, square5);

					textForDebug = textForDebug + "\nAircraft Carrier: " + "(" + startRow + "," + startSquare + "),("
							+ startRow + ","
							+ square2 + "),(" + startRow + "," + square3 + "),(" + startRow + "," + square4
							+ "),(" + startRow + "," + square5 + ")";
				}
				// the ship is alligned going right
				else {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the right
					while (startSquare + aircCarierLength > gridLengthMax) {
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare + 1;
					square3 = startSquare + 2;
					square4 = startSquare + 3;
					square5 = startSquare + 4;

					this.theGrid.addShipToGrid(ship1, startRow, startSquare);
					this.theGrid.addShipToGrid(ship1, startRow, square2);
					this.theGrid.addShipToGrid(ship1, startRow, square3);
					this.theGrid.addShipToGrid(ship1, startRow, square4);
					this.theGrid.addShipToGrid(ship1, startRow, square5);

					textForDebug = textForDebug + "\nAircraft Carrier: " + "(" + startRow + "," + startSquare + "),("
							+ startRow + ","
							+ square2 + "),(" + startRow + "," + square3 + "),(" + startRow + "," + square4
							+ "),(" + startRow + "," + square5 + ")";
				}
			}
		} // end of for loop
	}// end of AircraftCarierPlacerLogic method

	// the logic to place Battleship on the grid
	public void battleshipPlacerLogic() {
		Ship ship2 = new Ship(4, 4, "Battleship");
		int startRow, row2, row3, row4, startSquare, square2, square3, square4;
		int battleshipLength = 4;
		int gridLengthMax = this.theGrid.getGridLength();
		int gridlengthMin = gridLengthMax - gridLengthMax;
		boolean ifVerticalRow, verticalAllignedUp, horizontalIfAllignedLeft;
		boolean thereIsAShipOnStart, thereIsAShipOnRow2, thereIsAShipOnRow3, thereIsAShipOnRow4, thereIsAShipOnSquare2,
				thereIsAShipOnSquare3, thereIsAShipOnSquare4;

		for (int i = 0; i < 1; i++) {
			ifVerticalRow = randomBooleanGenerator();

			// if true the ship is alligned vertically
			if (ifVerticalRow == true) {
				verticalAllignedUp = randomBooleanGenerator();

				// the ship is alligned going up
				if (verticalAllignedUp == true) {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not on the top overlap the borders on the top
					while (startRow - battleshipLength < gridlengthMin) {
						startRow = RandomNumGenerator();
					}

					row2 = startRow - 1;
					row3 = startRow - 2;
					row4 = startRow - 3;

					thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);
					thereIsAShipOnRow3 = this.theGrid.isThereAShip(row3, startSquare);
					thereIsAShipOnRow4 = this.theGrid.isThereAShip(row4, startSquare);

					// to validate if there is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true || thereIsAShipOnRow3 == true
							|| thereIsAShipOnRow4 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship2, startRow, startSquare);
					this.theGrid.addShipToGrid(ship2, row2, startSquare);
					this.theGrid.addShipToGrid(ship2, row3, startSquare);
					this.theGrid.addShipToGrid(ship2, row4, startSquare);

					textForDebug = textForDebug + "\nBattleship: " + "(" + startRow + "," + startSquare + "),("
							+ row2 + "," + startSquare + "),(" + row3 + "," + startSquare + "),(" + row4 + ","
							+ startSquare + ")";
				}

				// the ship is alligned going down
				else {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the bottom
					while (startRow + battleshipLength > gridLengthMax) {
						startRow = RandomNumGenerator();
					}
					row2 = startRow + 1;
					row3 = startRow + 2;
					row4 = startRow + 3;

					thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);
					thereIsAShipOnRow3 = this.theGrid.isThereAShip(row3, startSquare);
					thereIsAShipOnRow4 = this.theGrid.isThereAShip(row4, startSquare);

					// to validate if there is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true || thereIsAShipOnRow3 == true
							|| thereIsAShipOnRow4 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship2, startRow, startSquare);
					this.theGrid.addShipToGrid(ship2, row2, startSquare);
					this.theGrid.addShipToGrid(ship2, row3, startSquare);
					this.theGrid.addShipToGrid(ship2, row4, startSquare);

					textForDebug = textForDebug + "\nBattleship: " + "(" + startRow + "," + startSquare + "),("
							+ row2 + "," + startSquare + "),(" + row3 + "," + startSquare + "),(" + row4 + ","
							+ startSquare + ")";
				}
			}

			// if not vertical, the ship is alligned horizontally
			else {
				horizontalIfAllignedLeft = randomBooleanGenerator();

				// the ship is alligned going left
				if (horizontalIfAllignedLeft == true) {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on left
					while (startSquare - battleshipLength < gridlengthMin) {
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare - 1;
					square3 = startSquare - 2;
					square4 = startSquare - 3;

					thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);
					thereIsAShipOnSquare3 = this.theGrid.isThereAShip(startRow, square3);
					thereIsAShipOnSquare4 = this.theGrid.isThereAShip(startRow, square4);

					// to validate if there is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true || thereIsAShipOnSquare3 == true
							|| thereIsAShipOnSquare4 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship2, startRow, startSquare);
					this.theGrid.addShipToGrid(ship2, startRow, square2);
					this.theGrid.addShipToGrid(ship2, startRow, square3);
					this.theGrid.addShipToGrid(ship2, startRow, square4);

					textForDebug = textForDebug + "\nBattleship: " + "(" + startRow + "," + startSquare + "),("
							+ startRow + ","
							+ square2 + "),(" + startRow + "," + square3 + "),(" + startRow + ","
							+ square4 + ")";
				}

				// the ship is alligned going right
				else {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the right
					while (startSquare + battleshipLength > gridLengthMax) {
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare + 1;
					square3 = startSquare + 2;
					square4 = startSquare + 3;

					thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);
					thereIsAShipOnSquare3 = this.theGrid.isThereAShip(startRow, square3);
					thereIsAShipOnSquare4 = this.theGrid.isThereAShip(startRow, square4);

					// to validate if there is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true || thereIsAShipOnSquare3 == true
							|| thereIsAShipOnSquare4 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship2, startRow, startSquare);
					this.theGrid.addShipToGrid(ship2, startRow, square2);
					this.theGrid.addShipToGrid(ship2, startRow, square3);
					this.theGrid.addShipToGrid(ship2, startRow, square4);

					textForDebug = textForDebug + "\nBattleship: " + "(" + startRow + "," + startSquare + "),("
							+ startRow + ","
							+ square2 + "),(" + startRow + "," + square3 + "),(" + startRow + ","
							+ square4 + ")";
				}
			}
		} // end of for loop
	}// end of battleshipPlacerLogic method
	
	//the logic to place Submarine on the grid 
	public void submarinePlacerLogic() {
		Ship ship3 = new Ship(3, 6, "Submarine");
		int startRow, row2, row3, startSquare, square2, square3;
		int submarineLength = 3;
		int gridLengthMax = this.theGrid.getGridLength();
		int gridlengthMin = gridLengthMax - gridLengthMax;
		boolean ifVerticalRow, verticalAllignedUp, horizontalIfAllignedLeft;
		boolean thereIsAShipOnStart, thereIsAShipOnRow2, thereIsAShipOnRow3,thereIsAShipOnSquare2,thereIsAShipOnSquare3;

		for (int i = 0; i < 1; i++) {
			ifVerticalRow = randomBooleanGenerator();

			// the ship is alligned vertically
			if (ifVerticalRow == true) {
				verticalAllignedUp = randomBooleanGenerator();

				// the ship is alligned going up
				if (verticalAllignedUp == true) {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the top
					while (startRow - submarineLength < gridlengthMin) {
						startRow = RandomNumGenerator();
					}
					row2 = startRow - 1;
					row3 = startRow - 2;

					thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);
					thereIsAShipOnRow3 = this.theGrid.isThereAShip(row3, startSquare);

					//to validate if there is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true || thereIsAShipOnRow3 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship3, startRow, startSquare);
					this.theGrid.addShipToGrid(ship3, row2, startSquare);
					this.theGrid.addShipToGrid(ship3, row3, startSquare);

					textForDebug = textForDebug + "\nSubmarine: " + "(" + startRow + "," + startSquare + "),("
							+ row2 + ","
							+ startSquare + "),(" + row3 + "," + startSquare + ")";
				}

				// the ship is alligned going down
				else {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the bottom
					while (startRow + submarineLength > gridLengthMax) {
						startRow = RandomNumGenerator();
					}
					row2 = startRow + 1;
					row3 = startRow + 2;

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					 thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);
					 thereIsAShipOnRow3 = this.theGrid.isThereAShip(row3, startSquare);

					 //to validate if there is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true || thereIsAShipOnRow3 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship3, startRow, startSquare);
					this.theGrid.addShipToGrid(ship3, row2, startSquare);
					this.theGrid.addShipToGrid(ship3, row3, startSquare);

					textForDebug = textForDebug + "\nSubmarine: " + "(" + startRow + "," + startSquare + "),("
							+ row2 + ","
							+ startSquare + "),(" + row3 + "," + startSquare + ")";
				}
			}

			// if not vertical, the ship is alligned horizontally
			else {
				 horizontalIfAllignedLeft = randomBooleanGenerator();

				 // the ship is alligned going left
				if (horizontalIfAllignedLeft == true) {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on left
					while (startSquare - submarineLength < gridlengthMin) {
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare - 1;
					square3 = startSquare - 2;

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					 thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);
					 thereIsAShipOnSquare3 = this.theGrid.isThereAShip(startRow, square3);

					 //to validate if there is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true
							|| thereIsAShipOnSquare3 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship3, startRow, startSquare);
					this.theGrid.addShipToGrid(ship3, startRow, square2);
					this.theGrid.addShipToGrid(ship3, startRow, square3);

					textForDebug = textForDebug + "\nSubmarine: " + "(" + startRow + "," + startSquare + "),("
							+ startRow + ","
							+ square2 + "),(" + startRow + "," + square3 + ")";
				}

				// the ship is alligned going right
				else {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the right
					while (startSquare + submarineLength > gridLengthMax) {
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare + 1;
					square3 = startSquare + 2;

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					 thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);
					 thereIsAShipOnSquare3 = this.theGrid.isThereAShip(startRow, square3);

					 //to validate if there is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true
							|| thereIsAShipOnSquare3 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship3, startRow, startSquare);
					this.theGrid.addShipToGrid(ship3, startRow, square2);
					this.theGrid.addShipToGrid(ship3, startRow, square3);

					textForDebug = textForDebug + "\nSubmarine: " + "(" + startRow + "," + startSquare + "),("
							+ startRow + ","
							+ square2 + "),(" + startRow + "," + square3 + ")";
				}
			}
		} // end of for loop
	}// end of submarinePlacerLogic method
	
	// the logic to place Destroyer on the grid
	public void destroyerPlacerLogic() {
		Ship ship4 = new Ship(2, 8, "Destroyer");
		int startRow, row2, startSquare, square2;
		int destroyerLength = 2;
		int gridLengthMax = this.theGrid.getGridLength();
		int gridlengthMin = gridLengthMax - gridLengthMax;
		boolean ifVerticalRow, verticalAllignedUp, horizontalIfAllignedLeft;
		boolean thereIsAShipOnStart, thereIsAShipOnRow2,thereIsAShipOnSquare2;

		for (int i = 0; i < 1; i++) {
			 ifVerticalRow = randomBooleanGenerator();

			 // the ship is alligned vertically
			if (ifVerticalRow == true) {
				 verticalAllignedUp = randomBooleanGenerator();

				 // the ship is alligned going up
				if (verticalAllignedUp == true) {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the top
					while (startRow - destroyerLength < gridlengthMin) {
						startRow = RandomNumGenerator();
					}
					row2 = startRow - 1;

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					 thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);

					 //to validate if tehre is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship4, startRow, startSquare);
					this.theGrid.addShipToGrid(ship4, row2, startSquare);

					textForDebug = textForDebug + "\nDestroyer: " + "(" + startRow + "," + startSquare + "),("
							+ row2 + "," + startSquare + ")";

				}

				// the ship is alligned going down
				else {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the bottom
					while (startRow + destroyerLength > gridLengthMax) {
						startRow = RandomNumGenerator();
					}
					row2 = startRow + 1;

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					 thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);

					 //to validate if tehre is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship4, startRow, startSquare);
					this.theGrid.addShipToGrid(ship4, row2, startSquare);

					textForDebug = textForDebug + "\nDestroyer: " + "(" + startRow + "," + startSquare + "),("
							+ row2 + "," + startSquare + ")";
				}
			}

			// if not vertical, the ship is alligned horizontally
			else {
				 horizontalIfAllignedLeft = randomBooleanGenerator();

				 // the ship is alligned going left
				if (horizontalIfAllignedLeft == true) {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on left
					while (startSquare - destroyerLength < gridlengthMin) {
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare - 1;

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					 thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);

					 //to validate if there is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship4, startRow, startSquare);
					this.theGrid.addShipToGrid(ship4, startRow, square2);
					
					textForDebug = textForDebug + "\nDestroyer: " + "(" + startRow + "," + startSquare + "),("
							+ startRow + "," + square2 + ")";
				}

				// the ship is alligned going right
				else {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					// to validate the ship does not overlap the borders on the right
					while (startSquare + destroyerLength > gridLengthMax) {
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare + 1;

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					 thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);

					 //to validate if there is a ship
					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship4, startRow, startSquare);
					this.theGrid.addShipToGrid(ship4, startRow, square2);

					textForDebug = textForDebug + "\nDestroyer: " + "(" + startRow + "," + startSquare + "),("
							+ startRow + "," + square2 + ")";
				}
			}
		} // end of for loop
	}// end of destroyerPlacerLogic method
	
	// the logic to place Patrol boat on the grid
	public void patrolBoatPlacerLogic() {
		Ship ship5 = new Ship(1, 10, "Patrol boat");
		int startRow, startSquare;
		boolean ifVerticalRow, verticalAllignedUp, horizontalIfAllignedLeft;
		boolean thereIsAShipOnStart;

		for (int i = 0; i < 1; i++) {
			 ifVerticalRow = randomBooleanGenerator();

			 // the ship is alligned vertically
			if (ifVerticalRow == true) {
				 verticalAllignedUp = randomBooleanGenerator();

				 // the ship is alligned going up
				if (verticalAllignedUp == true) {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);

					 //to validate if there is a ship
					while (thereIsAShipOnStart == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship5, startRow, startSquare);
					textForDebug = textForDebug + "\nPatrol boat: " + "(" + startRow + "," + startSquare + ")";
				}

				// the ship is alligned going down
				else {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);

					 //to validate if there is a ship
					while (thereIsAShipOnStart == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship5, startRow, startSquare);
					textForDebug = textForDebug + "\nPatrol boat: " + "(" + startRow + "," + startSquare + ")";
				}
			}

			// if not vertical, the ship is alligned horizontally
			else {
				 horizontalIfAllignedLeft = randomBooleanGenerator();

				 // the ship is alligned going left
				if (horizontalIfAllignedLeft == true) {
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);

					 //to validate if there is a ship 
					while (thereIsAShipOnStart == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship5, startRow, startSquare);
					textForDebug = textForDebug + "\nPatrol boat: " + "(" + startRow + "," + startSquare + ")";

				}

				else {// the ship is alligned going right
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					 thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);

					while (thereIsAShipOnStart == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship5, startRow, startSquare);
					textForDebug = textForDebug + "\nPatrol boat: " + "(" + startRow + "," + startSquare + ")";
				}
			}
		} // end of for loop
	}// end of patrolBoatPlacerLogic method

	//text for debug
	public void textForDebugPrinter(String textForDebug) {
		String output = textForDebug;
		JOptionPane.showMessageDialog(null, output);
	}

	//get text for debug 
	public String getTextForDebugPrinter() {
		String text = this.textForDebug;
		return text;
	}

	//to check if there is a ship on the square
	public boolean isThereAShipOnSquareOfThisGrid(int row, int square) {
		boolean isThereAShipOnSquare = this.theGrid.isThereAShip(row, square);

		return isThereAShipOnSquare;
	}

	//to get the points of the ship on grid
	public int getPointsOfShip(int row, int square) {
		int getPointsOfShip = this.theGrid.shipPoints(row, square);
		return getPointsOfShip;
	}

	//to get ship type on the grid
	public String getTypeOfShipOnGrid(int row, int square) {
		String getTypeOfShipOnGrid = this.theGrid.getShipType(row, square);
		return getTypeOfShipOnGrid;
	}

	//method to delete ship from teh grid
	public void shipWrecker(int row, int square) {
		this.theGrid.removeShipFromGrid(row, square);
	}

	/*
	 * public void shipRemoverTest(Ship ship){
	 * this.theGrid.removerTest(ship); }
	 * 
	 * }
	 */

	/*
	 * public boolean wasShotSquare(int row, int square){
	 * return this.theGrid.wasShot(row, square);
	 * }
	 */

}// end of class