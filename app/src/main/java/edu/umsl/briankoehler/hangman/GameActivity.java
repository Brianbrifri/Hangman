package edu.umsl.briankoehler.hangman;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.WindowManager;

/**
 * Created by b-kizzle on 5/4/16.
 */
public class GameActivity extends AppCompatActivity implements GameFragment.GameFragmentListener, GameControllerFragment.listener{

    //Final strings to hold tag for controller fragment and difficulty level passed in from previous activity
    private static final String GAME_DIFFICULTY = "edu.umsl.briankoehler.game_difficulty";
    private static final String THIRD_FRAGMENT = "third_fragment";
    GameFragment mGameFragment;
    GameControllerFragment mGameControllerFragment;

    //Creates a new intent when this activity is called by one.
    //Puts extra (gameDifficulty)
    public static Intent newIntent(Context packageContext, int gameDifficulty) {
        Intent intent = new Intent(packageContext, GameActivity.class);
        intent.putExtra(GAME_DIFFICULTY, gameDifficulty);
        return intent;
    }

    //When created, it gets the gameDifficulty passes in by previous activity
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity_layout);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        int gameDifficulty = (int) getIntent().getSerializableExtra(GAME_DIFFICULTY);


        //Wires up GameControllerFragment and the view fragment, GameFragment
        FragmentManager manager = getSupportFragmentManager();
        mGameControllerFragment = (GameControllerFragment) manager.findFragmentByTag(THIRD_FRAGMENT);
        if (mGameControllerFragment == null) {
            mGameControllerFragment = new GameControllerFragment();
            Bundle args = new Bundle();
            args.putInt("difficulty", gameDifficulty);
            mGameControllerFragment.setArguments(args);
            manager.beginTransaction()
                    .add(mGameControllerFragment, THIRD_FRAGMENT)
                    .commit();
        }

        mGameFragment = (GameFragment) manager.findFragmentById(R.id.fragment_container2);
        if(mGameFragment == null) {
            mGameFragment = new GameFragment();
            manager.beginTransaction()
                    .add(R.id.fragment_container2, mGameFragment)
                    .commit();
        }
        //Set listeners that both fragments will use
        mGameFragment.setListener(this);
        mGameControllerFragment.setListener(this);
    }

    //Once the Controller fragment is instantiated, it will call this function, via listener
    //to tell the view to update it's text view
    @Override
    public String updateTextView() {
        return mGameControllerFragment.displayBuilder();
    }

    //This gets called by the view fragment and passes in the char of the letter pressed
    //The activity then calls the matching function and processes the guess. The return is the
    //String of the updated text view for the view fragment to use
    @Override
    public String validateLetterGuess(char c) {
        return mGameControllerFragment.validateLetterGuess(c);
    }

    //Chicken test for back button pressed
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Such a Chicken...Ending the Game")
                .setMessage("Bawk! Bawk! Are you sure?? ")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    //Controller fragment calls this to let view fragment know that the game is over
    @Override
    public void setEndGameState() {
        mGameFragment.setEndGameState();
    }

    //Controller fragment calls this to display the lose game dialog
    @Override
    public void alertActivityOfLoss() {

        AlertDialog.Builder builder = new AlertDialog.Builder (this);
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("HAHAHA!!....you lose.")
                .setMessage("Do you want to play again?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mGameControllerFragment.resetGame();
                        mGameFragment.resetGame();
                        dialog.dismiss();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        //This is to move the dialog box down on the screen so as not to cover up the text view
        AlertDialog dialog = builder.create();
        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
        wmlp.gravity = Gravity.BOTTOM;
        dialog.show();
    }

    //Controller fragment calls this to display the game win dialog
    @Override
    public void alertActivityOfWin() {
        AlertDialog.Builder builder = new AlertDialog.Builder (this);
        builder.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Damn Smarty Pants! You Win!")
                .setMessage("Do you want to play again?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mGameControllerFragment.resetGame();
                        mGameFragment.resetGame();
                        dialog.dismiss();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
        wmlp.gravity = Gravity.BOTTOM;
        dialog.show();
    }

    //The controller fragment calls this to tell the view fragment which drawable to display
    @Override
    public void updateHangmanView(int sequence) {
        mGameFragment.updateHangmanDrawable(sequence);
    }
}
