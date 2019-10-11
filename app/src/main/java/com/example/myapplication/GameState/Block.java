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
        this.blockType=trueBlock.blockType;
        this.containedPiece=new Piece(trueBlock.containedPiece);
        this.isHighLighted=trueBlock.isHighLighted;
    }

    /**------------------------------------Getter Methods-----------------------------------------*/

    public Piece getContainedPiece() {
        return containedPiece;
    }

    public boolean getIsHighLighted() {
        return isHighLighted;
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
     * to String method for objects of the Block class
     *
     * @return toReturn: String that will
     * contain all the information about the block
     */
    public String toString() {
        String toReturn="Block Info\n";
        toReturn += "[Block Type: " + blockType + "]\n";
        toReturn += "----------------------";
        toReturn += containedPiece; //prints the contained piece
        toReturn += "----------------------";
        toReturn += "Is Piece Highlighted: " + isHighLighted;

        return toReturn;
    }
}
