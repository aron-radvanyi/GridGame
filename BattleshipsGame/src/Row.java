import java.util.ArrayList;
import javax.swing.JOptionPane; 

public class Row {

    private ArrayList <Square> Squares = new ArrayList<Square>();
    private int position;
    private final int NUM_OF_SQUARES = 10;

    //constructor
    public Row (int position){
        Square temporarySquare;
        for (int i = 1; i <= this.NUM_OF_SQUARES;i++){
            temporarySquare = new Square(i);
            this.Squares.add(temporarySquare);            
        }
        setPosition(position);
    }

    //getters and setters
    public void setPosition(int position){
        this.position = position;        
    }

    public int getPosition(){
        return this.position;
    }

    public ArrayList <Square> getSquares(){
        return this.Squares;
    }

    public Square printSquares(){
		Square prinSquare = Squares.get(1);
        return prinSquare;
	}

    public String gridToString(){
		Square toPrintposition=printSquares();
		String output = "coordinates" + toPrintposition;
		return output;
		
	}

	public void printDetailsSquare(){
		String output = gridToString();
		JOptionPane.showMessageDialog(null,output);

	}

}//end of class
