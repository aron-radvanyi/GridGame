import java.util.Random;
import javax.swing.JOptionPane;

public class BattleShip {

	private Grid theGrid = new Grid();

	private String textForDebug = "Here are the ships:";

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

	// method to choose whether vertical or horizontal row
	public boolean ifVerticalRow() {
		Random random = new Random();
		boolean vertical = random.nextBoolean();
		if (vertical == true) {
			return true;
		} else {
			return false;
		} // if return true, the row is vertical, if false the row is horizontal
	}

	// method to determine whether row is alligned up or down
	public boolean verticalIfAllignedUp() {
		Random random = new Random();
		boolean allignedUp = random.nextBoolean();
		if (allignedUp == true) {
			return true;
		} else {
			return false;
		} // if return true the row is alligned up, if false alligned down
	}

	// method to determine whether row is alligned left or right
	public boolean horizontalIfAllignedLeft() {
		Random random = new Random();
		boolean allignedLeft = random.nextBoolean();
		if (allignedLeft == true) {
			return true;
		} else {
			return false;
		} // if return true the row is alligned left, if false alligned right
	}

	public void aircraftCarierPlacerLogic() {// the logic to place AirCraft Carier to the grid

		Ship ship1 = new Ship(5, 2, "Aircraft Carrier");
		int startRow, startSquare, row2, row3, row4, row5, square2, square3, square4, square5;
		int aircCarierLength = 5;

		for (int i = 0; i < 1; i++) {
			boolean ifVerticalRow = ifVerticalRow();

			if (ifVerticalRow == true) {// the ship is alligned vertically
				boolean verticalAllignedUp = verticalIfAllignedUp();

				if (verticalAllignedUp == true) {// the ship is alligned going up
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startRow - aircCarierLength < 0) {// to validate the ship does not overlap the borders on the
																// top
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

					textForDebug = textForDebug + "\nAircraft Carrier" + "(" + startRow + "," + startSquare + ")" + ","
							+ "(" + row2 + ","
							+ startSquare + ")" + ",(" + row3 + "," + startSquare + ")," + "(" + row4 + ","
							+ startSquare + ")," + "(" + row5 + "," + startSquare + ")";
				}

				if (verticalAllignedUp == false) {// the ship is alligned going down
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startRow + aircCarierLength > 10) {// to validate the ship does not overlap the borders on
																// the bottom
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

					textForDebug = textForDebug + "\nAircraft Carrier" + "(" + startRow + "," + startSquare + ")" + ","
							+ "(" + row2 + ","
							+ startSquare + ")" + ",(" + row3 + "," + startSquare + ")," + "(" + row4 + ","
							+ startSquare + ")," + "(" + row5 + "," + startSquare + ")";
				}
			}
			if (ifVerticalRow == false) {// if not vertical, the ship is alligned horizontally
				boolean horizontalIfAllignedLeft = horizontalIfAllignedLeft();

				if (horizontalIfAllignedLeft == true) {// the ship is alligned going left
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startSquare - aircCarierLength < 0) {// to validate the ship does not overlap the borders on
																// left
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

					textForDebug = textForDebug + "\nAircraft Carrier" + "(" + startRow + "," + startSquare + ")" + ","
							+ "(" + startRow + ","
							+ square2 + ")" + ",(" + startRow + "," + square3 + ")," + "(" + startRow + "," + square4
							+ ")," + "(" + startRow + "," + square5 + ")";
				}

				if (horizontalIfAllignedLeft == false) {// the ship is alligned going right
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startSquare + aircCarierLength > 10) {// to validate the ship does not overlap the borders on
																	// the right
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

					textForDebug = textForDebug + "\nAircraft Carrier" + "(" + startRow + "," + startSquare + ")" + ","
							+ "(" + startRow + ","
							+ square2 + ")" + ",(" + startRow + "," + square3 + ")," + "(" + startRow + "," + square4
							+ ")," + "(" + startRow + "," + square5 + ")";
				}
			}
		} // end of for loop
	}// end of AircraftCarierPlacerLogic method

	public void battleshipPlacerLogic() {// the logic to place Battleship to the grid
		Ship ship2 = new Ship(4, 4, "Battleship");
		int startRow, row2, row3, row4, startSquare, square2, square3, square4;
		int battleshipLength = 4;

		for (int i = 0; i < 1; i++) {
			boolean ifVerticalRow = ifVerticalRow();

			if (ifVerticalRow == true) {// the ship is alligned vertically
				boolean verticalAllignedUp = verticalIfAllignedUp();

				if (verticalAllignedUp == true) {// the ship is alligned going up
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startRow - battleshipLength < 0) {// to validate the ship does not on the top // overlap the
																// borders on the
						startRow = RandomNumGenerator();
					}

					row2 = startRow - 1;
					row3 = startRow - 2;
					row4 = startRow - 3;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);
					boolean thereIsAShipOnRow3 = this.theGrid.isThereAShip(row3, startSquare);
					boolean thereIsAShipOnRow4 = this.theGrid.isThereAShip(row4, startSquare);

					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true || thereIsAShipOnRow3 == true
							|| thereIsAShipOnRow4 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship2, startRow, startSquare);
					this.theGrid.addShipToGrid(ship2, row2, startSquare);
					this.theGrid.addShipToGrid(ship2, row3, startSquare);
					this.theGrid.addShipToGrid(ship2, row4, startSquare);

					textForDebug = textForDebug + "\nBattleship" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ row2 + ","
							+ startSquare + ")" + ",(" + row3 + "," + startSquare + ")," + "(" + row4 + ","
							+ startSquare + ")";
				}

				if (verticalAllignedUp == false) {// the ship is alligned going down
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startRow + battleshipLength > 10) {// to validate the ship does not overlap the borders on
																// the bottom
						startRow = RandomNumGenerator();
					}
					row2 = startRow + 1;
					row3 = startRow + 2;
					row4 = startRow + 3;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);
					boolean thereIsAShipOnRow3 = this.theGrid.isThereAShip(row3, startSquare);
					boolean thereIsAShipOnRow4 = this.theGrid.isThereAShip(row4, startSquare);

					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true || thereIsAShipOnRow3 == true
							|| thereIsAShipOnRow4 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship2, startRow, startSquare);
					this.theGrid.addShipToGrid(ship2, row2, startSquare);
					this.theGrid.addShipToGrid(ship2, row3, startSquare);
					this.theGrid.addShipToGrid(ship2, row4, startSquare);

					textForDebug = textForDebug + "\nBattleship" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ row2 + ","
							+ startSquare + ")" + ",(" + row3 + "," + startSquare + ")," + "(" + row4 + ","
							+ startSquare + ")";
				}
			}
			if (ifVerticalRow == false) {// if not vertical, the ship is alligned horizontally
				boolean horizontalIfAllignedLeft = horizontalIfAllignedLeft();

				if (horizontalIfAllignedLeft == true) {// the ship is alligned going left
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startSquare - battleshipLength < 0) {// to validate the ship does not overlap the borders on
																// left
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare - 1;
					square3 = startSquare - 2;
					square4 = startSquare - 3;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);
					boolean thereIsAShipOnSquare3 = this.theGrid.isThereAShip(startRow, square3);
					boolean thereIsAShipOnSquare4 = this.theGrid.isThereAShip(startRow, square4);

					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true || thereIsAShipOnSquare3 == true
							|| thereIsAShipOnSquare4 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship2, startRow, startSquare);
					this.theGrid.addShipToGrid(ship2, startRow, square2);
					this.theGrid.addShipToGrid(ship2, startRow, square3);
					this.theGrid.addShipToGrid(ship2, startRow, square4);

					textForDebug = textForDebug + "\nBattleship" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ startRow + ","
							+ square2 + ")" + ",(" + startRow + "," + square3 + ")," + "(" + startRow + ","
							+ square4 + ")";
				}

				if (horizontalIfAllignedLeft == false) {// the ship is alligned going right
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startSquare + battleshipLength > 10) {// to validate the ship does not overlap the borders on
																	// the right
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare + 1;
					square3 = startSquare + 2;
					square4 = startSquare + 3;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);
					boolean thereIsAShipOnSquare3 = this.theGrid.isThereAShip(startRow, square3);
					boolean thereIsAShipOnSquare4 = this.theGrid.isThereAShip(startRow, square4);

					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true || thereIsAShipOnSquare3 == true
							|| thereIsAShipOnSquare4 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship2, startRow, startSquare);
					this.theGrid.addShipToGrid(ship2, startRow, square2);
					this.theGrid.addShipToGrid(ship2, startRow, square3);
					this.theGrid.addShipToGrid(ship2, startRow, square4);

					textForDebug = textForDebug + "\nBattleship" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ startRow + ","
							+ square2 + ")" + ",(" + startRow + "," + square3 + ")," + "(" + startRow + ","
							+ square4 + ")";
				}
			}
		} // end of for loop
	}// end of battleshipPlacerLogic method

	public void submarinePlacerLogic() {// the logic to place Submarine to the grid
		Ship ship3 = new Ship(3, 6, "Submarine");
		int startRow, row2, row3, startSquare, square2, square3;
		int submarineLength = 3;

		for (int i = 0; i < 1; i++) {
			boolean ifVerticalRow = ifVerticalRow();

			if (ifVerticalRow == true) {// the ship is alligned vertically
				boolean verticalAllignedUp = verticalIfAllignedUp();

				if (verticalAllignedUp == true) {// the ship is alligned going up
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startRow - submarineLength < 0) {// to validate the ship does not overlap the borders on the
															// top
						startRow = RandomNumGenerator();
					}
					row2 = startRow - 1;
					row3 = startRow - 2;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);
					boolean thereIsAShipOnRow3 = this.theGrid.isThereAShip(row3, startSquare);

					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true || thereIsAShipOnRow3 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship3, startRow, startSquare);
					this.theGrid.addShipToGrid(ship3, row2, startSquare);
					this.theGrid.addShipToGrid(ship3, row3, startSquare);

					textForDebug = textForDebug + "\nSubmarine" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ row2 + ","
							+ startSquare + ")" + ",(" + row3 + "," + startSquare + ")";

				}

				if (verticalAllignedUp == false) {// the ship is alligned going down
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startRow + submarineLength > 10) {// to validate the ship does not overlap the borders on the
																// bottom
						startRow = RandomNumGenerator();
					}
					row2 = startRow + 1;
					row3 = startRow + 2;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);
					boolean thereIsAShipOnRow3 = this.theGrid.isThereAShip(row3, startSquare);

					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true || thereIsAShipOnRow3 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship3, startRow, startSquare);
					this.theGrid.addShipToGrid(ship3, row2, startSquare);
					this.theGrid.addShipToGrid(ship3, row3, startSquare);

					textForDebug = textForDebug + "\nSubmarine" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ row2 + ","
							+ startSquare + ")" + ",(" + row3 + "," + startSquare + ")";
				}
			}
			if (ifVerticalRow == false) {// if not vertical, the ship is alligned horizontally
				boolean horizontalIfAllignedLeft = horizontalIfAllignedLeft();

				if (horizontalIfAllignedLeft == true) {// the ship is alligned going left
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startSquare - submarineLength < 0) {// to validate the ship does not overlap the borders on
																// left
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare - 1;
					square3 = startSquare - 2;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);
					boolean thereIsAShipOnSquare3 = this.theGrid.isThereAShip(startRow, square3);

					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true
							|| thereIsAShipOnSquare3 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship3, startRow, startSquare);
					this.theGrid.addShipToGrid(ship3, startRow, square2);
					this.theGrid.addShipToGrid(ship3, startRow, square3);

					textForDebug = textForDebug + "\nSubmarine" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ startRow + ","
							+ square2 + ")" + ",(" + startRow + "," + square3 + ")";
				}

				if (horizontalIfAllignedLeft == false) {// the ship is alligned going right
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startSquare + submarineLength > 10) {// to validate the ship does not overlap the borders on
																// the right
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare + 1;
					square3 = startSquare + 2;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);
					boolean thereIsAShipOnSquare3 = this.theGrid.isThereAShip(startRow, square3);

					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true
							|| thereIsAShipOnSquare3 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship3, startRow, startSquare);
					this.theGrid.addShipToGrid(ship3, startRow, square2);
					this.theGrid.addShipToGrid(ship3, startRow, square3);

					textForDebug = textForDebug + "\nSubmarine" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ startRow + ","
							+ square2 + ")" + ",(" + startRow + "," + square3 + ")";
				}
			}
		} // end of for loop
	}// end of submarinePlacerLogic method

	public void destroyerPlacerLogic() {// the logic to place Destroyer to the grid
		Ship ship4 = new Ship(2, 8, "Destroyer");
		int startRow, row2, startSquare, square2;
		int destroyerLength = 2;

		for (int i = 0; i < 1; i++) {
			boolean ifVerticalRow = ifVerticalRow();

			if (ifVerticalRow == true) {// the ship is alligned vertically
				boolean verticalAllignedUp = verticalIfAllignedUp();

				if (verticalAllignedUp == true) {// the ship is alligned going up
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startRow - destroyerLength < 0) {// to validate the ship does not overlap the borders on the
															// top
						startRow = RandomNumGenerator();
					}
					row2 = startRow - 1;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);

					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship4, startRow, startSquare);
					this.theGrid.addShipToGrid(ship4, row2, startSquare);

					textForDebug = textForDebug + "\nDestroyer" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ row2 + "," + startSquare + ")";

				}

				if (verticalAllignedUp == false) {// the ship is alligned going down
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startRow + destroyerLength > 10) {// to validate the ship does not overlap the borders on the
																// bottom
						startRow = RandomNumGenerator();
					}
					row2 = startRow + 1;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnRow2 = this.theGrid.isThereAShip(row2, startSquare);

					while (thereIsAShipOnStart == true || thereIsAShipOnRow2 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship4, startRow, startSquare);
					this.theGrid.addShipToGrid(ship4, row2, startSquare);
					textForDebug = textForDebug + "\nDestroyer" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ row2 + "," + startSquare + ")";
				}
			}
			if (ifVerticalRow == false) {// if not vertical, the ship is alligned horizontally
				boolean horizontalIfAllignedLeft = horizontalIfAllignedLeft();

				if (horizontalIfAllignedLeft == true) {// the ship is alligned going left
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startSquare - destroyerLength < 0) {// to validate the ship does not overlap the borders on
																// left
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare - 1;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);

					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship4, startRow, startSquare);
					this.theGrid.addShipToGrid(ship4, startRow, square2);
					textForDebug = textForDebug + "\nDestroyer" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ startRow + ","
							+ square2 + ")";
				}

				if (horizontalIfAllignedLeft == false) {// the ship is alligned going right
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					while (startSquare + destroyerLength > 10) {// to validate the ship does not overlap the borders on
																// the right
						startSquare = RandomNumGenerator();
					}
					square2 = startSquare + 1;

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);
					boolean thereIsAShipOnSquare2 = this.theGrid.isThereAShip(startRow, square2);

					while (thereIsAShipOnStart == true || thereIsAShipOnSquare2 == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship4, startRow, startSquare);
					this.theGrid.addShipToGrid(ship4, startRow, square2);
					textForDebug = textForDebug + "\nDestroyer" + "(" + startRow + "," + startSquare + ")" + "," + "("
							+ startRow + ","
							+ square2 + ")";
				}
			}
		} // end of for loop
	}// end of destroyerPlacerLogic method

	public void patrolBoatPlacerLogic() {// the logic to place Patrol boat to the grid
		Ship ship5 = new Ship(1, 10, "Patrol boat");
		int startRow, startSquare;

		for (int i = 0; i < 1; i++) {
			boolean ifVerticalRow = ifVerticalRow();

			if (ifVerticalRow == true) {// the ship is alligned vertically
				boolean verticalAllignedUp = verticalIfAllignedUp();

				if (verticalAllignedUp == true) {// the ship is alligned going up
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);

					while (thereIsAShipOnStart == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship5, startRow, startSquare);
					textForDebug = textForDebug + "\nPatrol boat:" + "(" + startRow + "," + startSquare + ")";

				}

				if (verticalAllignedUp == false) {// the ship is alligned going down
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);

					while (thereIsAShipOnStart == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship5, startRow, startSquare);
					textForDebug = textForDebug + "\nPatrol boat:" + "(" + startRow + "," + startSquare + ")";
				}
			}
			if (ifVerticalRow == false) {// if not vertical, the ship is alligned horizontally
				boolean horizontalIfAllignedLeft = horizontalIfAllignedLeft();

				if (horizontalIfAllignedLeft == true) {// the ship is alligned going left
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);

					while (thereIsAShipOnStart == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship5, startRow, startSquare);
					textForDebug = textForDebug + "\nPatrol boat:" + "(" + startRow + "," + startSquare + ")";

				}

				if (horizontalIfAllignedLeft == false) {// the ship is alligned going right
					startSquare = RandomNumGenerator();
					startRow = RandomNumGenerator();

					boolean thereIsAShipOnStart = this.theGrid.isThereAShip(startRow, startSquare);

					while (thereIsAShipOnStart == true) {
						startSquare = RandomNumGenerator();
						startRow = RandomNumGenerator();
					}

					this.theGrid.addShipToGrid(ship5, startRow, startSquare);
					textForDebug = textForDebug + "\nPatrol boat:" + "(" + startRow + "," + startSquare + ")";

				}
			}
		} // end of for loop

	}// end of patrolBoatPlacerLogic method

	public void textForDebugPrinter(String textForDebug) {
		String output = textForDebug;
		JOptionPane.showMessageDialog(null, output);
	}

	public String getTextForDebugPrinter(){
		String text = this.textForDebug;
		return text;
	}

	public boolean isThereAShipOnSquareOfThisGrid(int row, int square) {
		boolean isThereAShipOnSquare = this.theGrid.isThereAShip(row, square);

		return isThereAShipOnSquare;
	}

	public int getPointsOfShip(int row, int square) {
		int getPointsOfShip = this.theGrid.shipPoints(row, square);
		return getPointsOfShip;
	}

	public String getTypeOfShipOnGrid(int row, int square) {
		String getTypeOfShipOnGrid = this.theGrid.getShipType(row, square);
		return getTypeOfShipOnGrid;
	}	

	public void shipWrecker(int row, int square) {
		this.theGrid.removeShipFromGrid(row, square);
	}

	/*public void shipRemoverTest(Ship ship){
		this.theGrid.removerTest(ship);	}

	}*/

	/*public boolean wasShotSquare(int row, int square){
		return this.theGrid.wasShot(row, square);
	}*/

	

}// end of class