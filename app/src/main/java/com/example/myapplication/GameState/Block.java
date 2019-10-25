/**
 * class for objects of the block class
 *
 * @author John Haas
 */

package com.example.myapplication.GameState;


public class Block {

    //instance variables
    private Tile blockType;
    private Piece containedPiece;
    private boolean isHighLighted;

    /**
     * constructor for objects of the Block class
     *
     * @param conPiece the piece that will be contained in the block
     * @param typeOfLand type of block this block will be
     */
    public Block(Piece conPiece, Tile typeOfLand) {
        blockType=typeOfLand;
        containedPiece=conPiece;
        isHighLighted=false; //all blocks start out unhighlighted
    }

    /**
     * secondary constructor for objects of the Block class that start out empty
     *
     * @param typeOfLand type of block this block will be
     */
    public Block(Tile typeOfLand) {
        blockType=typeOfLand;
        containedPiece=null; //empty block
        isHighLighted=false; //all blocks start unhighlighted
    }


    /**
     * copy constructor for objects of the block class
     *
     * @param trueBlock the block that  contains the true data
     */
    public Block(Block trueBlock) {
        if(trueBlock == null) {
            this.blockType=null;
            this.containedPiece = null;
            this.isHighLighted = false;
        }
        this.blockType=trueBlock.blockType;
        if(trueBlock.containedPiece != null) {
            this.containedPiece = new Piece(trueBlock.containedPiece);
        } else {
            this.containedPiece = null;
        }
        this.isHighLighted=trueBlock.isHighLighted;
    }

    /**------------------------------------Getter Methods-----------------------------------------*/

    public Tile getBlockType() { return blockType; }
    public Piece getContainedPiece() {
        return containedPiece;
    }
    public boolean isHighLighted() { return isHighLighted; }

    /**
     * method that checks if a block is empty or not
     *
     * @return true if block contains a piece
     *         false if block is empty
     */
    public boolean containsPiece() {
        return !(this.containedPiece == null);
    }

    /**-----------------------------------Setter Methods------------------------------------------*/

    public void setContainedPiece(Piece containedPiece) {
        this.containedPiece = containedPiece;
    }

    public void setHighLighted(boolean highLighted) {
        isHighLighted = highLighted;
    }

    /**-----------------------------------Generic Methods----------------------------------------*/

    /**
     * method that checks if a given block is highlightable
     *
     * @param currentTeamsTurn the team whos turn it currently is
     * @return true if block is highlightable
     *         false if block is not highlightable
     */
    public boolean isBlockHighlightable(Team currentTeamsTurn) {
        //pieces can't walk on water. Jesus rank not implemented yet
        if(this.getBlockType() == Tile.WATER) {
            return false;
        }
        //pieces can't move onto fellow teammates squares
        if (this.containsPiece() &&
                this.getContainedPiece().getPieceTeam() == currentTeamsTurn){
            return false;
        }
        //pieces can always move elsewhere
        return true;
    }

    /**
     * to String method for objects of the Block class
     *
     * @return toReturn: String that will
     * contain all the information about the block
     */
    public String toString() {
        String toReturn="Block Info\n";
        toReturn += "[Block Type: " + blockType + "]\n";
        toReturn += "----------------------\n";
        toReturn += containedPiece + "\n"; //calls piece toString method
        toReturn += "----------------------\n";
        toReturn += "Is Piece Highlighted: " + isHighLighted + "\n\n";

        return toReturn;
    }
}
