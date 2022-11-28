import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Play {

    BattleShip play = new BattleShip();

    public void mainPlay() {
        printWelcome();

        boolean playDebug = choiceInputMode();

        play.shipPlacer();
        shootingOnShips(playDebug);
    }

    // method to print welcome message
    public void printWelcome() {
        String output = "Welcome in the game!" + "\n " + "\nplease, press OK to continue!";
        JOptionPane.showMessageDialog(null, output);

    }

    // method to chose Normal/Debug mode
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

    public void shootingOnShips(boolean playDebug) {
        int row, square;
        String rowAString, squareAString, itIsAHit, itsNotAHit, output;
        final int NUMBER_OF_SHOTS = 10;
        int minNumber = 0;
        int maxNumber = 10;
        int numberOfPoints = 0;
        String text = play.getTextForDebugPrinter();
        List<String> whatShipsWereSinked = new ArrayList<String>();
        // List<Shot> theShots = new ArrayList<Shot>();

        for (int i = 0; i < NUMBER_OF_SHOTS; i++) {
            int numberOFShots = 0;

            // if player wants to play debug, the text for debug is shown
            if (playDebug) {
                JOptionPane.showMessageDialog(null, text);
            }

            while (true) {
                try {
                    rowAString = JOptionPane.showInputDialog("row you shoot at:");
                    row = Integer.parseInt(rowAString);
                    break;
                } catch (Exception ex) {
                    String errorMessage = "This is not a number!";
                    JOptionPane.showMessageDialog(null, errorMessage);
                }
            }

            while (row < minNumber || row > maxNumber) {
                rowAString = JOptionPane.showInputDialog("row you shoot at:");
                row = Integer.parseInt(rowAString);
            }

            while (true) {
                try {
                    squareAString = JOptionPane.showInputDialog("square you shoot at:");
                    square = Integer.parseInt(squareAString);
                    break;
                } catch (Exception ex) {
                    String errorMessage = "This is not a number!";
                    JOptionPane.showMessageDialog(null, errorMessage);
                }
            }

            while (square < minNumber || square > maxNumber) {

                squareAString = JOptionPane.showInputDialog("square you shoot at:");
                square = Integer.parseInt(squareAString);
            }

            // to prevent shooting on teh same spot twice
            // created shot object and put it into an arraylist, determined if arraylist
            // contains shot
            // but prevented looping again

            // List<Integer> arrayIntShots = new ArrayList<Integer>();
            // theShots.add(1, shot);

            // Shot shot = new Shot(numberOFShots);

            // arrayIntShots.add(row,square);
            // theShots.add(i, shot);

           /*  boolean didPlayerShotHereAlready = play.wasShotSquare(row, square);

            if (didPlayerShotHereAlready == true) {
                rowAString = JOptionPane.showInputDialog("You already shot on that row!" + "\n row you shoot at:");
                row = Integer.parseInt(rowAString);

                squareAString = JOptionPane
                        .showInputDialog("You already shot on that square!" + "\n square you shoot at:");
                square = Integer.parseInt(squareAString);
            }*/

            /*
             * Shot shot = new Shot(numberOFShots);
             * theShots.add(shot);
             * if(theShots.contains(shot)&&numberOFShots!=0){
             * rowAString = JOptionPane.showInputDialog("You already shot on that row!"
             * +"\n row you shoot at:");
             * row = Integer.parseInt(rowAString);
             * 
             * squareAString =
             * JOptionPane.showInputDialog("You already shot on that square!"
             * +"\n square you shoot at:");
             * square = Integer.parseInt(squareAString);
             * }
             */

            // to check if it's a hit
            boolean hit = play.isThereAShipOnSquareOfThisGrid(row, square);

            if (hit) {

                int points = play.getPointsOfShip(row, square);
                numberOfPoints = numberOfPoints + points;
                String typeOfShip = play.getTypeOfShipOnGrid(row, square);

                itIsAHit = "Nice, you hit a: " + typeOfShip;
                JOptionPane.showMessageDialog(null, itIsAHit);

                whatShipsWereSinked.add(typeOfShip);
                /*
                 * play.gtterShip(row, square);
                 * play.shipRemoverTest(null);
                 */

                // to destroy the whole ship which was hit
                shipWreckingVertical(typeOfShip, row, square);
                shipWreckingHorizontal(typeOfShip, row, square);
                // play.preventerShootingThereTwice(row, square);

                int sizeOfWhatShipsWereSinked = whatShipsWereSinked.size();
                if (sizeOfWhatShipsWereSinked == 5) {
                    String output2 = "\nGreat job, all ships were sinked!";
                    JOptionPane.showMessageDialog(null, output2);
                    break;
                }
            } else {
                itsNotAHit = "Miss!" + "\n..or maybe you sinked the ship already? :)";
                JOptionPane.showMessageDialog(null, itsNotAHit);

            }

            // to prevent shooting on teh same spot twice
        } // end of for loop

        output = "GAME OVER" + "\nYour score: " + numberOfPoints;

        JOptionPane.showMessageDialog(null, output);

    }

    public void shipWreckingVertical(String typeofTheShipVert, int row, int square) {
        int firstRowUp, secRowUp, thirdRowUp, fourthRowUp;
        int firstRowDown, secRowDown, thirdRowDown, fourthRowDown;

        play.shipWrecker(row, square);

        firstRowUp = row - 1;
        boolean isThereAShip = play.isThereAShipOnSquareOfThisGrid(firstRowUp, square);

        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(firstRowUp, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(firstRowUp, square);
            }
        }

        secRowUp = row - 2;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(secRowUp, square);

        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(secRowUp, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(secRowUp, square);
            }
        }

        thirdRowUp = row - 3;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(thirdRowUp, square);
        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(thirdRowUp, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(thirdRowUp, square);
            }
        }

        fourthRowUp = row - 4;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(fourthRowUp, square);
        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(fourthRowUp, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(fourthRowUp, square);
            }
        }

        firstRowDown = row + 1;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(firstRowDown, square);
        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(firstRowDown, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(firstRowDown, square);
            }
        }

        secRowDown = row + 2;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(secRowDown, square);
        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(secRowDown, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(secRowDown, square);
            }
        }

        thirdRowDown = row + 3;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(thirdRowDown, square);
        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(thirdRowDown, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(thirdRowDown, square);
            }
        }

        fourthRowDown = row + 4;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(fourthRowDown, square);
        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(fourthRowDown, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(fourthRowDown, square);
            }
        }
    }

    public void shipWreckingHorizontal(String typeofTheShipHor, int row, int square) {
        int firstSquareLeft, secSquareLeft, thirdSquareLeft, fourthSquareLeft;
        int firstSquareRight, secSquareRight, thirdSquareRight, fourthSquareRight;

        play.shipWrecker(row, square);

        firstSquareLeft = square - 1;
        boolean isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, firstSquareLeft);

        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(row, firstSquareLeft);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, firstSquareLeft);
            }
        }

        secSquareLeft = square - 2;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, secSquareLeft);

        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(row, secSquareLeft);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, secSquareLeft);
            }
        }

        thirdSquareLeft = square - 1;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, thirdSquareLeft);

        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(row, thirdSquareLeft);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, thirdSquareLeft);
            }
        }

        fourthSquareLeft = square - 1;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, fourthSquareLeft);

        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(row, fourthSquareLeft);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, fourthSquareLeft);
            }
        }

        firstSquareRight = square + 1;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, firstSquareRight);

        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(row, firstSquareRight);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, firstSquareRight);
            }
        }

        secSquareRight = square + 2;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, secSquareRight);

        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(row, secSquareRight);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, secSquareRight);
            }
        }

        thirdSquareRight = square + 3;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, thirdSquareRight);

        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(row, thirdSquareRight);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, thirdSquareRight);
            }
        }

        fourthSquareRight = square + 4;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, fourthSquareRight);

        if (isThereAShip) {
            String getshipType = play.getTypeOfShipOnGrid(row, fourthSquareRight);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, fourthSquareRight);
            }
        }
    }

}// end of class
