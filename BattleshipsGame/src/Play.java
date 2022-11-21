import javax.swing.JOptionPane;

public class Play {

    BattleShip play = new BattleShip();

    public void mainPlay() {
        printWelcome();

        boolean answer = choiceInputMode();

        if (answer == true) {
            play.debugMode();
        } else {
            play.shipPlacer();
        }

        shootingOnShips();

    }

    public void printWelcome() {
        String output = "Welcome in the game!" + "\n " + "\nplease, press OK to continue!";
        JOptionPane.showMessageDialog(null, output);

    }

    public boolean choiceInputMode() {
        int answer = JOptionPane.showConfirmDialog(null,
                "Would you like to play in debug mode?" + "\nPlease,choose yes/no.", null, JOptionPane.YES_NO_OPTION);
        boolean debugModeChosen = false;
        if (answer == JOptionPane.YES_OPTION) {
            debugModeChosen = true;
        }
        if (answer == JOptionPane.NO_OPTION) {
            debugModeChosen = false;
        }
        return debugModeChosen;

    }

    public void shootingOnShips() {
        int row, square;
        String rowAString, squareAString;
        final int NUMBER_OF_SHOTS = 1;
        int minNumber = 0;
        int maxNumber = 10;
        int numberOfPoints = 0;
        String itIsAHit, itsNotAHit;
        String output;

        for (int i = 0; i < NUMBER_OF_SHOTS; i++) {

            rowAString = JOptionPane.showInputDialog("row you shoot at:");
            row = Integer.parseInt(rowAString);

            while (row < minNumber || row > maxNumber) {
                rowAString = JOptionPane.showInputDialog("row you shoot at:");
                row = Integer.parseInt(rowAString);
            }
            /*
             * try {
             * row = Integer.parseInt(rowAString);
             * 
             * }
             * catch(Exception exe){
             * rowAString = JOptionPane.showInputDialog("row you shoot at:");
             * }
             */

            squareAString = JOptionPane.showInputDialog("square you shoot at:");
            square = Integer.parseInt(squareAString);

            while (square < minNumber || square > maxNumber) {
                squareAString = JOptionPane.showInputDialog("square you shoot at:");
                square = Integer.parseInt(squareAString);
            }

            boolean hit = play.isThereAShipOnSquareOfThisGrid(row, square);

            if (hit == true) {

                int points = play.getPointsOfShip(row, square);
                numberOfPoints = numberOfPoints + points;
                String typeOfShip = play.getTypeOfShipOnGrid(row, square);

                itIsAHit = "Nice, you hit a: " + typeOfShip;
                JOptionPane.showMessageDialog(null, itIsAHit);
            } else {
                itsNotAHit = "Miss!";
                JOptionPane.showMessageDialog(null, itsNotAHit);

            }
        }

        output = "GAME OVER"+"\nYour score: " + numberOfPoints;

        JOptionPane.showMessageDialog(null, output);

    }

}
