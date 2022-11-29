import java.util.ArrayList;
//this class is for the object Grid and all related methods 
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

	//to get the points of the ship
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

	//to get the type of the ship
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

	//to get the ship on the grid
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
	//to add ship to teh grid
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

	//to remove the ship from the square 
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

	//to get the length of teh grid
	public int getGridLength(){
		return this.NUM_OF_ROWS;
	}
}// end of the class
