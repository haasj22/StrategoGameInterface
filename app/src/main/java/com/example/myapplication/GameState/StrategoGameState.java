/**
 * class that contains all information the game will need to function
 *
 * @author John Haas
 * @author Jordan Ho
 * @author Kavya Mandla
 * @version October 2019
 */

package com.example.myapplication.GameState;

import java.util.ArrayList;

public class StrategoGameState {

    //max number of rows and cols in board
    private final int COLMAX = 10;
    private final int ROWMAX = 10;

    //maximum amount of pieces each game can have
    private final int numOfMarshalls = 1;
    private final int numOfGenerals = 1;
    private final int numOfColonels = 2;
    private final int numOfMajors = 3;
    private final int numOfCaptains = 4;
    private final int numOfLietenants = 4;
    private final int numOfSergeants = 4;
    private final int numOfMiners = 5;
    private final int numOfScouts = 8;
    private final int numOfSpy = 1;
    private final int numOfBombs = 6;

    //array that represents the state of the game board
    private Block[][] board = new Block[ROWMAX][COLMAX];

    //player one's information
    private int playerOneID;
    private int playerOneTimer; //in milliseconds

    //variables that will store what pieces player one has in play
    private ArrayList<Piece> playerOnePieces;
    //necessary for transitioning between phases
    private boolean playerOneHasFlag;

    //player two's information
    private int playerTwoID;
    private int playerTwoTimer; //in milliseconds
    //variables that will store what pieces player two has in play
    private ArrayList<Piece> playerTwoPieces;
    //necessary for transitioning between phases
    private boolean playerTwoHasFlag;

    //what phase the game is currently in
    private Phase currentPhase;

    //id of the player whose turn it is
    private int currentPlayer;

    /**
     * Constructor for objects of class StrategoGameState
     */
    public StrategoGameState(){
        //player one sets up first
        playerOneID = 1;
        playerOneTimer = 3000;

        //player one starts with no pieces on the board
        playerOnePieces= new ArrayList<Piece>();
        playerOneHasFlag = false;

        //player one does not get access to any of player two's information
        playerTwoID = 2;
        playerTwoTimer = 0;

        //player one does not get to see where player two placed his pieces
        playerTwoPieces=new ArrayList<Piece>();
        playerTwoHasFlag = false;

        //starts the game out in setup phase
        currentPhase = Phase.SETUP_PHASE;

        //player one starts
        currentPlayer = 1;

        //creates basic game board
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(i != 4 || i !=5) {
                    board[i][j] = new Block(Tile.GRASS);
                    break;
                }
                if(j != 2 || j != 3 || j != 6 || j != 7) {
                    board[i][j] = new Block(Tile.WATER);
                    break;
                }
                board[i][j] = new Block(Tile.BRIDGE);
            }
        }

    }

    /**
     * Deep Copy Constructor of the StrategoGameState
     *
     * @param trueState the one true state of the game that would be copied.
     */
    public StrategoGameState(StrategoGameState trueState){

        //copies player one's information
        this.playerOneID = trueState.playerOneID;
        this.playerOneTimer = trueState.playerOneTimer;

        //copies player one's pieces
        for(Piece p: trueState.playerOnePieces) {
            this.playerOnePieces.add(new Piece(p));
        }

        //sees whether player one has won yet
        this.playerOneHasFlag = trueState.playerOneHasFlag;

        //copies player two's information
        this.playerTwoID = trueState.playerTwoID;
        this.playerTwoTimer = trueState.playerTwoTimer;

        //copies player two's pieces
        for(Piece p: trueState.playerTwoPieces) {
            this.playerTwoPieces.add(new Piece(p));
        }

        //sees whether player two has won yet
        this.playerTwoHasFlag = trueState.playerTwoHasFlag;

        //copies the phase of the game
        this.currentPhase = trueState.currentPhase;

        //finds who's turn it is
        this.currentPlayer = trueState.currentPlayer;

        //copies the game board
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                this.board[i][j] = new Block(trueState.board[i][j]);
            }
        }

    }
    /**-----------------------------------GETTER METHODS------------------------------------------*/

    public Block[][] getBoard() {
        return board;
    }

    public ArrayList<Piece> getPlayerOnePieces() {
        return playerOnePieces;
    }

    public boolean getIsPlayerOneHasFlag() {
        return playerOneHasFlag;
    }

    public ArrayList<Piece> getPlayerTwoPieces() {
        return playerTwoPieces;
    }

    public boolean getIsPlayerTwoHasFlag() {
        return playerTwoHasFlag;
    }

    public Phase getCurrentPhase() {
        return currentPhase;
    }

    /**-----------------------------------SETTER METHODS------------------------------------------*/

    public void setBoard(Block[][] board) {
        this.board = board;
    }

    public void setPlayerOnePieces(ArrayList<Piece> playerOnePieces) {
        this.playerOnePieces = playerOnePieces;
    }

    public void setPlayerOneHasFlag(boolean playerOneHasFlag) {
        this.playerOneHasFlag = playerOneHasFlag;
    }

    public void setPlayerTwoPieces(ArrayList<Piece> playerTwoPieces) {
        this.playerTwoPieces = playerTwoPieces;
    }

    public void setPlayerTwoHasFlag(boolean playerTwoHasFlag) {
        this.playerTwoHasFlag = playerTwoHasFlag;
    }

    public void setCurrentPhase(Phase currentPhase) {
        this.currentPhase = currentPhase;
    }

    /**--------------------------------SETUP_PHASE METHODS----------------------------------------*/

    /**
     * addPieceToGame method
     * allows players to set pieces on the board if its SET_UP phase
     * @param placedPiece desired piece to be placed
     * @param x the desired x coordinate of the placed piece
     * @param y the desired y coordinate of the placed piece
     * @return true if piece is set at the desired location
     *         false if the piece cannot be placed at the desired location
     */
    public boolean addPieceToGame(Piece placedPiece, int x, int y) {
        //TODO finish adding logic to and implementing the method
        //makes sure x is a legal value
        if(x >= ROWMAX || x < 0 ) {
            return false;
        }
        //makes sure y is a legal value
        else if ( y >= COLMAX || y < 0 ) {
            return false;
        }
        //makes sure the current phase is the setup phase
        else if (this.currentPhase != Phase.SETUP_PHASE) {
            return false;
        }


        return true;
    }

    /**
     * removePieceFromGame method
     * removes pieces from board during set up phase
     * @param x x variable of the piece to be removed
     * @param y y variable of the piece to be removed
     * @return true if piece has been removed
     *         false if placement lacks a piece or coordinates are invalid
     */
    public boolean removePieceFromGame(int x, int y) {
        //TODO implement removePieceFromGame method functionality
        return false;
    }

    /**
     * movePieceFromGame method
     * allows the user to move his pieces around the game board during SETUP_PHASE
     * @param x1 x variable of the original location
     * @param x2 x variable of the desired location
     * @param y1 y variable of the original location
     * @param y2 y variable of the desired location
     * @return true if piece is properly moved from point 1 to 2
     *         false if the coordinates are invalid
     */
    public boolean movePieceDuringSetup(int x1, int x2, int y1, int y2) {
        //TODO implement movePieceDuringSetup method
        return false;
    }

    /**-------------------------------------------------------------------------------------------*/

    /**
     * transitionPhases method
     * transitions from SETUP_PHASE to PLAY_PHASE
     * @return true if conditions to transition phases are met
     *         false if conditions to transition phases are not met
     */
    public boolean transitionPhases() {
        //TODO implement conditions under which the function returns false
        if(this.currentPhase == Phase.SETUP_PHASE) {
            this.currentPhase = Phase.PLAY_PHASE;
            return true;
        }
        return false;
    }

    /**--------------------------------------PLAY_PHASE-------------------------------------------*/

    /**
     * movePiece method
     * allows players to move their piece during PLAY_PHASE
     * @param x1 original x-coordinate of piece
     * @param x2 x-coordinate piece wants to be moved to
     * @param y1 original y-coordinate of piece
     * @param y2 y-coordinate piece wants to be moved to
     * @return true once piece has been moved
     *         false if the coordinates are invalid
     */
    public boolean movePiece(int x1, int x2, int y1, int y2) {
        //TODO implement movePiece function
        if(this.currentPhase != Phase.PLAY_PHASE) {
            return false;
        }
        return true;
    }

    /**
     * helper method for movePiece that triggers
     * when two pieces collide on game board
     * @param attacker piece that is on the offense
     * @param defender piece that is defending
     * @return true if attacker wins
     *         false if defender wins
     */
    private boolean attackPiece(Piece attacker, Piece defender) {
        //TODO implment attackPiece method
        return false;
    }

    /**
     * isGameOver method
     * checks if the game is over
     * @return true if both players have their flags
     */
    public boolean isGameOver() {
        //TODO implement isGameOver method
        return false;
    }

    /**-------------------------------------------------------------------------------------------*/

    /**-----------------------------------General Methods-----------------------------------------*/

    /**
     * method that allows the user to forfeit the game
     * @return true once game has been ended
     */
    public boolean forfeitGame() {
        //TODO Implement forfeitGame method
        return true;
    }

    /**
     * method that prints class information as a String
     * @return toReturn: the String that contains all the gameState information
     */
    @Override
    public String toString(){
        //prints all the game state information
        String toReturn = "\nStratego Game State:\n";

        toReturn += "[Player One ID: " + playerOneID + "]\n";
        toReturn += "[Player One Timer: " + playerOneTimer + "]\n";

        toReturn += "[Player Two ID: " + playerTwoID + "]\n";
        toReturn += "[Player Two Timer: " + playerTwoTimer + "]\n";

        toReturn += "[Current Phase: " + currentPhase + "]\n";

        //prints whose turn it is based on currentPlayer variable
        if(currentPlayer == 1){
            toReturn += "Player One's Turn\n";
        }
        else{
            toReturn += "Player Two's turn\n";
        }

        //prints whats stored in each board block
        toReturn += "------------------------\n";
        for(int i=0; i<ROWMAX; i++) {
            for(int j=0; j<COLMAX; j++) {
                toReturn += "[Block " + (i+1) + ":" + (j+1) + "]";
                toReturn += board[i][j];
            }
            toReturn += "\n";
        }
        toReturn += "------------------------\n";

        //return information
        return toReturn;
    }

    /**-------------------------------------------------------------------------------------------*/

}
