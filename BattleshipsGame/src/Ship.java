public class Ship {
	private int length;
	private int points;
	private String type;
	
	//constructor
	
	public Ship (int length, int points, String type) {
		setLength(length);
		setPoints(points);
		setType(type);
	}
	
	
	//getters and setters 
	
	public int getLength() {
		return this.length;		
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}//end of class
