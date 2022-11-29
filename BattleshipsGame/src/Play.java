import java.util.*;
import java.io.*;
//import java.lang.*;

import javax.swing.JOptionPane;

//this class captures the interactions with the player
public class Play {

    BattleShip play = new BattleShip();

    public void mainPlay() {
        boolean playDebug;
        String playerName;

        printWelcome();
        playerName = askPlayerName();

        playDebug = choiceInputMode();

        play.shipPlacer();
        shootingOnShips(playDebug, playerName);
    }

    // method to print welcome message
    public void printWelcome() {
        String output = "Welcome in the game!" + "\n " + "\nplease, press OK to continue!";
        JOptionPane.showMessageDialog(null, output);
    }

    public String askPlayerName() {
        String playerName = JOptionPane.showInputDialog("Please, type in your playername!");
        return playerName;
    }

    // method to chose Normal/Debug mode
    // if the chosen option is Yes returns true
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

    // method to facilitate the shooting on the ships
    public void shootingOnShips(boolean playDebug, String playerName) {
        int row, square, points, sizeOfWhatShipsWereSinked;
        String rowAString, squareAString, itIsAHit, itsNotAHit, output, typeOfShip;
        boolean hit;
        final int NUMBER_OF_SHOTS = 10;
        int minNumber = 0;
        int maxNumber = 10;
        int numberOfPoints = 0;
        String textDebug = play.getTextForDebugPrinter();
        List<String> whatShipsWereSinked = new ArrayList<String>();
        int numOfShips = 5;

        // ArrayList<Integer[]> theShotsDone = new ArrayList<Integer[]>();
        // Integer[] coordinatesOfShots = new Integer[2];

        // main loop for shooting
        for (int i = 0; i < NUMBER_OF_SHOTS; i++) {

            // if player wants to play debug, the text for debug is shown for each iteration
            if (playDebug) {
                JOptionPane.showMessageDialog(null, textDebug);
            }

            // to validate the palyer does not type in else than int
            while (true) {
                try {
                    rowAString = JOptionPane.showInputDialog("Captain " + playerName + " which row you shoot at?");
                    row = Integer.parseInt(rowAString);
                    break;
                } catch (Exception ex) {
                    String errorMessage = "Captain " + playerName + " This is not a number!";
                    JOptionPane.showMessageDialog(null, errorMessage);
                }
            }

            // to validate the int provided is not higher/lower than it is possible
            while (row < minNumber || row > maxNumber) {
                rowAString = JOptionPane.showInputDialog(
                        "Captain " + playerName + " this number is not between 1-10" + " \nWhich row you shoot at?");
                row = Integer.parseInt(rowAString);
            }

            // to validate the palyer does not type in else than int
            while (true) {
                try {
                    squareAString = JOptionPane
                            .showInputDialog("Captain " + playerName + " which square you shoot at?");
                    square = Integer.parseInt(squareAString);
                    break;
                } catch (Exception ex) {
                    String errorMessage = "Captain " + playerName + " this is not a number!";
                    JOptionPane.showMessageDialog(null, errorMessage);
                }
            }

            // to validate the int provided is not higher/lower than it is possible
            while (square < minNumber || square > maxNumber) {

                squareAString = JOptionPane.showInputDialog(
                        "Captain " + playerName + " this number is not between 1-10" + " \nWhich square you shoot at?");
                square = Integer.parseInt(squareAString);
            }

            // the plan to call the method in to avoid shooting on teh same spot
            // notShootingOnSameSpot(int row, int square)

            // to check if it's a hit, isThereAShipOnSquareOfThisGrid(row, square) returns
            // true if there is a ship
            hit = play.isThereAShipOnSquareOfThisGrid(row, square);

            if (hit) {

                // returns the points for the ship on that location
                points = play.getPointsOfShip(row, square);
                numberOfPoints = numberOfPoints + points;

                // returns the type of ship hit as string
                typeOfShip = play.getTypeOfShipOnGrid(row, square);

                itIsAHit = "Captain " + playerName + " nice job, you hit a: " + typeOfShip;
                JOptionPane.showMessageDialog(null, itIsAHit);

                // adds the string typeOfShip to the arraylist
                whatShipsWereSinked.add(typeOfShip);

                // to destroy the whole ship which was hit
                shipWreckingVertical(typeOfShip, row, square);
                shipWreckingHorizontal(typeOfShip, row, square);

                // breaks the loop if all the 5 ships were sinked
                sizeOfWhatShipsWereSinked = whatShipsWereSinked.size();
                if (sizeOfWhatShipsWereSinked == numOfShips) {
                    String output2 = "Captain " + playerName + "\nGreat job, all ships were sinked!";
                    JOptionPane.showMessageDialog(null, output2);
                    break;
                }
            } else {
                itsNotAHit = "Captain " + playerName + " You Missed!" + "\n..or maybe you sinked the ship already? :)";
                JOptionPane.showMessageDialog(null, itsNotAHit);

            }
        } // end of for loop

        output = "GAME OVER" + "\nCaptain " + playerName + " Your score is: " + numberOfPoints;

        JOptionPane.showMessageDialog(null, output);

        // calls the scoreboardmaker method in
        scoreBoardMaker(numberOfPoints, playerName);
    }

    // to create the high score board
    public void scoreBoardMaker(int numberOfPoints, String playerName) {
        Map<Integer, String> scoreBoard = new TreeMap<Integer, String>(Collections.reverseOrder());

        scoreBoard.put(numberOfPoints, playerName);
        for (Map.Entry<Integer, String> entry : scoreBoard.entrySet()) {
            String scoreBoardTxt = "High score board: " + "\n" + "\npoints: " + entry.getKey() + " player name: "
                    + entry.getValue();
            String scoreBoardtxtForData = scoreBoardTxt;
            scoreBoardWriter(scoreBoardtxtForData);
        }
    }

    // method planned to avoid shooting on the same spot
    /*
     * public void notShootingOnSameSpot(int row, int square){
     * 
     * //checking if the araylist contains the same array
     * boolean didPlayerShootThere=theShotsDone.contains(coordinatesOfShots);
     * 
     * //adding that array to the arraylist
     * coordinatesOfShots[0]=row;
     * coordinatesOfShots[1]=square;
     * 
     * //adding the array of shots to the arraylist
     * theShotsDone.add(coordinatesOfShots);
     * 
     * //looping again if it contains
     * while(didPlayerShootThere==true){
     * rowAString = JOptionPane.showInputDialog(
     * "Captain " + playerName + " you shoot here already" +
     * " \nWhich row you shoot at?");
     * row = Integer.parseInt(rowAString);
     * 
     * squareAString = JOptionPane.showInputDialog(
     * "Captain " + playerName + " you shoot here already" +
     * " \nWhich square you shoot at?");
     * square = Integer.parseInt(squareAString);
     * }
     * 
     * }
     */

    // to write the high score board int oa local txt file
    public void scoreBoardWriter(String scoreBoardtxtForData) {
        try {
            FileWriter file = new FileWriter("scoreBoardtxtForData");
            BufferedWriter output = new BufferedWriter(file);

            output.write(scoreBoardtxtForData);
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    // removes the ship from the grid on the locations it can possibly be if
    // vertically alligned
    public void shipWreckingVertical(String typeofTheShipVert, int row, int square) {
        int firstRowUp, secRowUp, thirdRowUp, fourthRowUp;
        int firstRowDown, secRowDown, thirdRowDown, fourthRowDown;
        boolean isThereAShip;
        String getshipType;

        play.shipWrecker(row, square);
        firstRowUp = row - 1;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(firstRowUp, square);

        // if there is a ship checks if that ship is the same ship already hit and
        // removes that ship from the grid
        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(firstRowUp, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(firstRowUp, square);
            }
        }

        secRowUp = row - 2;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(secRowUp, square);

        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(secRowUp, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(secRowUp, square);
            }
        }

        thirdRowUp = row - 3;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(thirdRowUp, square);
        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(thirdRowUp, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(thirdRowUp, square);
            }
        }

        fourthRowUp = row - 4;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(fourthRowUp, square);
        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(fourthRowUp, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(fourthRowUp, square);
            }
        }

        firstRowDown = row + 1;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(firstRowDown, square);
        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(firstRowDown, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(firstRowDown, square);
            }
        }

        secRowDown = row + 2;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(secRowDown, square);
        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(secRowDown, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(secRowDown, square);
            }
        }

        thirdRowDown = row + 3;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(thirdRowDown, square);
        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(thirdRowDown, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(thirdRowDown, square);
            }
        }

        fourthRowDown = row + 4;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(fourthRowDown, square);
        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(fourthRowDown, square);
            if (getshipType == typeofTheShipVert) {
                play.shipWrecker(fourthRowDown, square);
            }
        }
    }

    // removes the ship from the grid on the locations it can possibly be if
    // horizontally alligned
    public void shipWreckingHorizontal(String typeofTheShipHor, int row, int square) {
        int firstSquareLeft, secSquareLeft, thirdSquareLeft, fourthSquareLeft;
        int firstSquareRight, secSquareRight, thirdSquareRight, fourthSquareRight;
        boolean isThereAShip;
        String getshipType;

        play.shipWrecker(row, square);

        firstSquareLeft = square - 1;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, firstSquareLeft);

        // if there is a ship checks if that ship is the same ship already hit and
        // removes that ship from the grid
        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(row, firstSquareLeft);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, firstSquareLeft);
            }
        }

        secSquareLeft = square - 2;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, secSquareLeft);

        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(row, secSquareLeft);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, secSquareLeft);
            }
        }

        thirdSquareLeft = square - 3;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, thirdSquareLeft);

        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(row, thirdSquareLeft);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, thirdSquareLeft);
            }
        }

        fourthSquareLeft = square - 4;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, fourthSquareLeft);

        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(row, fourthSquareLeft);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, fourthSquareLeft);
            }
        }

        firstSquareRight = square + 1;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, firstSquareRight);

        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(row, firstSquareRight);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, firstSquareRight);
            }
        }

        secSquareRight = square + 2;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, secSquareRight);

        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(row, secSquareRight);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, secSquareRight);
            }
        }

        thirdSquareRight = square + 3;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, thirdSquareRight);

        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(row, thirdSquareRight);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, thirdSquareRight);
            }
        }

        fourthSquareRight = square + 4;
        isThereAShip = play.isThereAShipOnSquareOfThisGrid(row, fourthSquareRight);

        if (isThereAShip) {
            getshipType = play.getTypeOfShipOnGrid(row, fourthSquareRight);
            if (getshipType == typeofTheShipHor) {
                play.shipWrecker(row, fourthSquareRight);
            }
        }
    }

}// end of class
