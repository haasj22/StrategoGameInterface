/**
 * Main activity that will test the game state
 *
 * @author John Haas
 * @version October 2019
 */

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.GameState.Piece;
import com.example.myapplication.GameState.Rank;
import com.example.myapplication.GameState.StrategoGameState;

public class MainActivity extends AppCompatActivity {
    //instance variables
    EditText changingTextView;
    StrategoGameState firstInstance;
    StrategoGameState secondInstance;
    StrategoGameState thirdInstance;
    StrategoGameState fourthInstance;

    /**
     * Shows what will happen when the application starts
     *
     * @param savedInstanceState state upon creation of our game
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //calls parent constructor
        super.onCreate(savedInstanceState);
        //sets the layoout to that which we created
        setContentView(R.layout.activity_main);
        //makes it so the textView can scroll
        changingTextView = (EditText)findViewById(R.id.textEditor);
        changingTextView.setMovementMethod(new ScrollingMovementMethod());

        //finds the button and tells it to run the tests upon being clicked
        Button testButton = (Button)findViewById(R.id.testButton);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runTests();
            }
        });
    }

    /**
     * method that will test the game state upon clicking the runTests button
     */
    public void runTests() {
                //initializes first and second instances
                changingTextView.setText("Creating new game state and copying it\n",
                        TextView.BufferType.SPANNABLE);
                firstInstance = new StrategoGameState();
                secondInstance = new StrategoGameState(firstInstance);

                //adds pieces to red's side of the board needed for rest fo tests
                changingTextView.append("Adding pieces to red team's side of the board\n");
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.ONE), 7, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.FIVE), 9, 9);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.SIX), 6, 7);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.TWO), 8, 2);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.NINE), 8, 9);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.SPY), 6, 2);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.EIGHT), 6, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.NINE), 7, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.FIVE), 6, 6);
                changingTextView.append(firstInstance.toString());

                //shows that the removePieceFromGame and movePieceDuringSetup methods work
                changingTextView.append("Removes the red Team's one from the board\n");
                firstInstance.removePieceFromGame(7, 3);
                changingTextView.append("Swaps red teams six with its five\n");
                firstInstance.movePieceDuringSetup(9, 9, 6, 7);
                changingTextView.append("Moves red teams two from 9:3 to 9:5\n");
                firstInstance.movePieceDuringSetup(8, 2, 8, 4);
                changingTextView.append(firstInstance.toString());

                //shows that transitionPhases works
                changingTextView.append("Randomizes the rest of red team's board and moves to blue team's turn\n");
                firstInstance.transitionPhases();
                changingTextView.append(firstInstance.toString());

                //adds necessary pieces to blue side of the board and changes the game into play phase
                changingTextView.append("Blue Team adds a couple pieces and then moves the game into play phase\n");
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.ONE), 3, 2);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.BOMB), 3, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.FLAG), 2, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.FOUR), 3, 6);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.NINE), 3, 7);
                firstInstance.transitionPhases();
                changingTextView.append(firstInstance.toString());

                //shows that the highlightBlocks function works
                changingTextView.append("Highlights block red team can move their spy to\n");
                firstInstance.tapOnSquare(6, 2);
                changingTextView.append(firstInstance.toString());

                changingTextView.append("Red team moves their spy from 7:3 to 6:3\n");
                firstInstance.tapOnSquare(5,2);

                changingTextView.append("Highlights block blue team can move their one to\n");
                firstInstance.tapOnSquare(3, 2);

                changingTextView.append("Blue team moves their one from 4:3 to 5:3\n");
                firstInstance.tapOnSquare(4, 2);

                changingTextView.append("Highlights blocks red team can move their spy to\n");
                firstInstance.tapOnSquare(5,2);

                //shows that the spy will kill a one even though its of lower value
                changingTextView.append("Red team attacks the one at 5:3 with their spy\n");
                firstInstance.tapOnSquare(4,2);
                changingTextView.append(firstInstance.toString());

                //shows that the scout highlights different blocks than normal
                changingTextView.append("Highlights blocks blue team can move their scout to from 4:8\n");
                firstInstance.tapOnSquare(3, 7);
                changingTextView.append(firstInstance.toString());

                //shows that scouts will make units visible
                changingTextView.append("Red team attacks a six at 7:8 with their scout\n");
                firstInstance.tapOnSquare(6,7);
                changingTextView.append(firstInstance.toString());

                changingTextView.append("Highlights blocks red team can move their miner to\n");
                firstInstance.tapOnSquare(6, 3);

                changingTextView.append("Moves red miner from 7:4 to 6:4\n");
                firstInstance.tapOnSquare(5, 3);

                changingTextView.append("Highlights blocks blue four can move to\n");
                firstInstance.tapOnSquare(3, 6);

                changingTextView.append("Moves four from 4:7 to 5:7\n");
                firstInstance.tapOnSquare(4,6);

                changingTextView.append("Highlights blocks red team can move their miner to\n");
                firstInstance.tapOnSquare(5,3);

                changingTextView.append("Moves red teams from 6:4 to 5:4");
                firstInstance.tapOnSquare(4,3);

                changingTextView.append("Highlights blocks blue four can move to\n");
                firstInstance.tapOnSquare(4, 6);

                changingTextView.append("Moves four from 5:7 to 6:7\n");
                firstInstance.tapOnSquare(5,6);

                changingTextView.append("Highlights blocks red team can move their miner to\n");
                firstInstance.tapOnSquare(4,3);

                //shows that the attackBomb method works and eights can destroy them
                changingTextView.append("Attacks the bomb at 4:4 with red team's miner\n");
                firstInstance.tapOnSquare(3,3);
                changingTextView.append(firstInstance.toString());

                changingTextView.append("Highlights blocks blue four can move to\n");
                firstInstance.tapOnSquare(5, 6);

                //shows a basic unit attack
                changingTextView.append("Attacks the red teams five at 7:7 with blue teams four\n");
                firstInstance.tapOnSquare(6,6);
                changingTextView.append(firstInstance.toString());

                //shows that attack flag works and will adjust the has flag variable
                changingTextView.append("Red teams miner attacks the flag and wins\n");
                firstInstance.tapOnSquare(3,3);
                firstInstance.tapOnSquare(2,3);
                changingTextView.append(firstInstance.toString());

                //shows that the game knows when it is over
                int result = firstInstance.isGameOver();

                if(result == -1) {
                    changingTextView.append("Red Team Has Lost\n");
                } else if (result == 1) {
                    changingTextView.append("Blue Team Has Lost\n");
                } else {
                    changingTextView.append("Game is not yet over\n");
                }

                //shows the copy constructors are in fact deep copys
                changingTextView.append("Second Instance Data\n");
                changingTextView.append(secondInstance.toString());

                changingTextView.append("Fourth Instance Data\n");
                thirdInstance=new StrategoGameState();
                fourthInstance=new StrategoGameState(thirdInstance);
                changingTextView.append(fourthInstance.toString());

                //shows that forfeit game works
                fourthInstance.forfeitGame();
                changingTextView.append(fourthInstance.toString());
        }


}
