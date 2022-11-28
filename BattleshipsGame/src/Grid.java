import java.util.ArrayList;

public class Grid {

	private ArrayList<Row> Rows = new ArrayList<Row>();
	private final int NUM_OF_ROWS = 10;

	// constructor
	public Grid() {
		Row temporaryRow;
		for (int i = 1; i <= this.NUM_OF_ROWS; i++) {
			temporaryRow = new Row(i);
			this.Rows.add(temporaryRow);
		}
	}// end Grid

	// method to determine if there is a ship on square
	public boolean isThereAShip(int row, int square) {
		for (Row temporaryRow : this.Rows) {
			if (temporaryRow.getPosition() == row) {
				// found the correct row
				for (Square tempSquare : temporaryRow.getSquares()) {
					if (tempSquare.getPosition() == square) {
						// found the correct square
						return tempSquare.isThereAShip();
					}
				}
			}
		}
		return false;
	}// end of the isThereAShip

	public int shipPoints(int row, int square) {
		for (Row temporaryRow : this.Rows) {
			if (temporaryRow.getPosition() == row) {
				// found the correct row
				for (Square tempSquare : temporaryRow.getSquares()) {
					if (tempSquare.getPosition() == square) {
						// found the correct square
						return tempSquare.getPointsOfShipSquare();
					}
				}
			}
		}
		return 0;
	}

	public String getShipType(int row, int square) {
		for (Row temporaryRow : this.Rows) {
			if (temporaryRow.getPosition() == row) {
				// found the correct row
				for (Square tempSquare : temporaryRow.getSquares()) {
					if (tempSquare.getPosition() == square) {
						// found the correct square
						return tempSquare.getTypeOfShip();
					}
				}
			}
		}
		return "";
	}

	public Ship getTheShip(int row, int square) {
		Ship temporaryShip = new Ship(row, square, null);
		for (Row temporaryRow : this.Rows) {
			if (temporaryRow.getPosition() == row) {
				// found the correct row
				for (Square tempSquare : temporaryRow.getSquares()) {
					if (tempSquare.getPosition() == square) {
						// found the correct square
						return tempSquare.getShip();
					}
				}
			}
		}
		return temporaryShip;
	}

	/*public void removeShipFromGrid(int row, int square) {
		Ship ship = getTheShip(row, square);
		this.

	}*/

	public void addShipToGrid(Ship ship, int row, int square) {
		for (Row temporaryRow : this.Rows) {
			if (temporaryRow.getPosition() == row) {
				// found correct row
				for (Square tempSquare : temporaryRow.getSquares()) {
					if (tempSquare.getPosition() == square) {
						// found correct square
						tempSquare.setTheShip(ship);
					}
				}
			}
		}
	}// end of addShipToGrid

	public void removeShipFromGrid(int row, int square) {
		for (Row temporaryRow : this.Rows) {
			if (temporaryRow.getPosition() == row) {
				// found correct row
				for (Square tempSquare : temporaryRow.getSquares()) {
					if (tempSquare.getPosition() == square) {
						// found correct square
						tempSquare.removeShip(null);
					}
				}
			}
		}
	}// end of addShipToGrid

	/*public void removerTest (Ship ship){
		this.Rows.remove(ship);
	}*/

	/*public boolean wasShot(int row, int square) {
		for (Row temporaryRow : this.Rows) {
			if (temporaryRow.getPosition() == row) {
				// found correct row
				for (Square tempSquare : temporaryRow.getSquares()) {
					if (tempSquare.getPosition() == square) {
						// found correct square
						return tempSquare.setWasShot();
					}
				}
			}
		}
		return false;
	}*/

	


}// end of the class
