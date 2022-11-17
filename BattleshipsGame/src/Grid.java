import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Grid {

    private ArrayList <Row> Rows = new ArrayList <Row> ();
	private final int NUM_OF_ROWS = 10;

    //constructor
    public Grid() {
		Row temporaryRow;
		for(int i = 1; i <= this.NUM_OF_ROWS; i++) {
			temporaryRow = new Row(i);
			this.Rows.add(temporaryRow);
		}
	}//end Grid

    //method to determine if there is a ship on square 
    public boolean isThereAShip(int row, int square) {
		for(Row temporaryRow : this.Rows) {
			if(temporaryRow.getPosition() == row) {
				//found the correct row
				for(Square tempSquare : temporaryRow.getSquares()) {
					if(tempSquare.getPosition() == square) {
						//found the correct square
						return tempSquare.isThereAShip();
					}
				}
			}
		}
		return false;
	}//end of the isThereAShip

    public void addShipToGrid(Ship ship, int row, int square) {
		for(Row temporaryRow : this.Rows) {
			if(temporaryRow.getPosition() == row) {
				//found correct row
				for(Square tempSquare : temporaryRow.getSquares()) {
					if(tempSquare.getPosition() == square) {
						//found correct square
						tempSquare.setTheShip(ship);
					}
				}
			}
		}
	}//end of addShipToGrid

	public Row getShipCordinates(){
		Row toPrintposition = Rows.get(2);		
		return toPrintposition;

	}

	public String gridToString(){
		Row toPrintposition=getShipCordinates();
		String output = "coordinates" + toPrintposition;
		return output;
		
	}

	public void printDetailsRow(){
		String output = gridToString();
		JOptionPane.showMessageDialog(null,output);

	}

	
	
    


}//end of the class
