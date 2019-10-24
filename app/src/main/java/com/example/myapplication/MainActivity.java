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
    EditText changingTextView;
    int timeClicked=0;
    StrategoGameState firstInstance;
    StrategoGameState secondInstance;
    StrategoGameState thirdInstance;
    StrategoGameState fourthInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changingTextView = (EditText)findViewById(R.id.textEditor);
        changingTextView.setMovementMethod(new ScrollingMovementMethod());

        Button testButton = (Button)findViewById(R.id.testButton);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeClicked++;
                Log.i("msg", "" + timeClicked);
                runTests();
            }
        });
    }

    public void runTests() {
        Log.i("Here", "clicked");
        switch(timeClicked) {
            case 1:
                changingTextView.setText("Creating new game state and copying it\n",
                        TextView.BufferType.SPANNABLE);
                firstInstance = new StrategoGameState();
                secondInstance = new StrategoGameState(firstInstance);
                changingTextView.append(firstInstance.toString());
                break;
            case 2:
                changingTextView.setText("Adding pieces to red team's side of the board\n",
                        TextView.BufferType.SPANNABLE);

                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.ONE), 7, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.FIVE), 9, 9);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.SIX), 6, 7);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.TWO), 8, 2);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.NINE), 8, 9);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.FOUR), 0, 0);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.THREE), 7, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.SPY), 6, 2);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.EIGHT), 6, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.NINE), 7, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.FIVE), 6, 6);

                break;
            case 4:
                changingTextView.append("Removes the red Team's one from the board\n");
                firstInstance.removePieceFromGame(7, 3);
                changingTextView.append("Swaps red teams six with its five\n");
                firstInstance.movePieceDuringSetup(9, 9, 6, 7);
                changingTextView.append("Moves red teams two from 9:3 to 9:5\n");
                firstInstance.movePieceDuringSetup(8, 2, 8, 4);
                break;
            case 5:
                changingTextView.append("Randomizes the rest of red team's board and moves to blue team's turn\n");
                firstInstance.transitionPhases();
                break;
            case 6:
                changingTextView.append("Blue Team adds a couple pieces and then moves the game into play phase\n");
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.ONE), 3, 2);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.BOMB), 3, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.FLAG), 2, 3);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.FOUR), 3, 6);
                firstInstance.addPieceToGame(new Piece(firstInstance.getCurrentTeamsTurn(), Rank.NINE), 3, 7);
                firstInstance.transitionPhases();
                break;
            case 7:
                changingTextView.append("Highlights block red team can move their spy to n\n");
                firstInstance.tapOnSquare(6, 2);
                break;
            case 8:
                changingTextView.append("Red team moves their spy from 7:3 to 6:3\n");
                firstInstance.tapOnSquare(5,2);
                break;
            case 9:
                changingTextView.append("Highlights block blue team can move their one to\n");
                firstInstance.tapOnSquare(3, 2);
                break;
            case 10:
                changingTextView.append("Blue team moves their one from 4:3 to 5:3\n");
                firstInstance.tapOnSquare(4, 2);
                break;
            case 11:
                changingTextView.append("Highlights blocks red team can move their spy to\n");
                firstInstance.tapOnSquare(5,2);
                break;
            case 12:
                changingTextView.append("Red team attacks the one with their spy\n");
                firstInstance.tapOnSquare(4,2);
                break;
            case 13:
                changingTextView.append("Highlights blocks blue team can move their scout to\n");
                firstInstance.tapOnSquare(3, 7);
                break;
            case 14:
                changingTextView.append("Red team attacks a six with their spy\n");
                firstInstance.tapOnSquare(6,7);
                break;
            case 15:
                changingTextView.append("Highlights blocks red team can move their miner to\n");
                firstInstance.tapOnSquare(6, 3);
                break;
            case 16:
                changingTextView.append("Moves red miner from 7:4 to 6:4\n");
                firstInstance.tapOnSquare(5, 3);
                break;
            case 17:
                changingTextView.append("Highlights blocks blue four can move to\n");
                firstInstance.tapOnSquare(3, 6);
                break;
            case 18:
                changingTextView.append("Moves four from 4:7 to 5:7\n");
                firstInstance.tapOnSquare(4,6);
                break;
            case 19:
                changingTextView.append("Highlights blocks red team can move their miner to\n");
                firstInstance.tapOnSquare(5,3);
                break;
            case 20:
                changingTextView.append("Moves red teams from 6:4 to 5:4");
                firstInstance.tapOnSquare(4,3);
                break;
            case 21:
                changingTextView.append("Highlights blocks blue four can move to\n");
                firstInstance.tapOnSquare(4, 6);
                break;
            case 22:
                changingTextView.append("Moves four from 5:7 to 6:7\n");
                firstInstance.tapOnSquare(5,6);
                break;
            case 23:
                changingTextView.append("Highlights blocks red team can move their miner to\n");
                firstInstance.tapOnSquare(4,3);
                break;
            case 24:
                changingTextView.append("Attacks the bomb with red team's miner\n");
                firstInstance.tapOnSquare(3,3);
                break;
            case 25:
                changingTextView.append("Highlights blocks blue four can move to\n");
                firstInstance.tapOnSquare(5, 6);
                break;
            case 26:
                changingTextView.append("Attacks the red teams five with blue teams four\n");
                firstInstance.tapOnSquare(6,6);
                break;
            case 27:
                changingTextView.append("Red teams miner attacks the flag and wins");
                firstInstance.tapOnSquare(3,3);
                firstInstance.tapOnSquare(2,3);
                changingTextView.setText(firstInstance.toString(),
                        TextView.BufferType.SPANNABLE);
            case 28:
                changingTextView.setText(secondInstance.toString(),
                        TextView.BufferType.SPANNABLE);
            case 29:
                thirdInstance=new StrategoGameState();
                fourthInstance=new StrategoGameState(thirdInstance);
                changingTextView.setText(fourthInstance.toString(),
                        TextView.BufferType.SPANNABLE);
        }

    }
}
