public class Square {

   private int position;
   private Ship theShip;

   // contrsuctor
   public Square(int position) {
      setPosition(position);
   }

   public boolean isThereAShip() {
      if (theShip == null) {
         return false;
      }
      return true;
   }

   // getters and setters
   public void setTheShip(Ship theShip) {
      this.theShip = theShip;
   }

   public Ship getShip(){
      return this.theShip;
   }

   public int getPosition() {
      return this.position;
   }

   public void setPosition(int position) {
      this.position = position;
   }

   public int getPointsOfShipSquare() {
      return this.theShip.getPoints();
   }

   public String getTypeOfShip(){
      return this.theShip.getType();
   }

}// end of class
