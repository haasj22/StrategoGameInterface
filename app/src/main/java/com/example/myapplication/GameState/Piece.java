/**
 * class for objects of the Piece class
 *
 * @author John Haas
 */

package com.example.myapplication.GameState;

public class Piece {

    //instance variables
    private Team pieceTeam;
    private Rank pieceRank;
    private boolean isVisible;

    /**
     * normal constructors for objects of the piece class
     *
     * @param pTeam team the piece is on
     * @param pRank rank of the piece
     */
    public Piece(Team pTeam, Rank pRank) {
        pieceTeam = pTeam;
        pieceRank = pRank;
        isVisible = false;
    }

    public Piece(Piece truePiece) {
        if(truePiece == null) {
            return;
        }
        this.pieceTeam = truePiece.pieceTeam;
        this.pieceRank = truePiece.pieceRank;
        this.isVisible = truePiece.isVisible;
    }

    /**-----------------------------------Getter Methods------------------------------------------*/

    public Team getPieceTeam() {
        return pieceTeam;
    }

    public Rank getPieceRank() {
        return pieceRank;
    }

    public boolean getIsVisible() {
        return isVisible;
    }

    /**-----------------------------------Setter Methods------------------------------------------*/

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    /**-----------------------------------Generic Methods-----------------------------------------*/

    /**
     * method that returns the data of the piece as a string
     *
     * @return toReturn: the data of a piece as a String
     */
    public String toString() {
        //prints all the piece variables
        String toReturn = "Piece Information\n";
        toReturn += "[Pieces Team: " + pieceTeam + "]\n";
        toReturn += "[Pieces Rank: " + pieceRank + "]\n";
        toReturn += "[Is Piece Visible: " + isVisible + "]\n";

        return toReturn;
    }
}
