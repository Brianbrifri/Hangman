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
import android.view.WindowManager;

/**
 * Created by b-kizzle on 5/4/16.
 */
public class GameActivity extends AppCompatActivity implements GameFragment.GameFragmentListener, GameControllerFragment.listener{

    private static final String GAME_DIFFICULTY = "edu.umsl.briankoehler.game_difficulty";
    private static final String THIRD_FRAGMENT = "third_fragment";
    GameFragment mGameFragment;
    GameControllerFragment mGameControllerFragment;

    public static Intent newIntent(Context packageContext, int gameDifficulty) {
        Intent intent = new Intent(packageContext, GameActivity.class);
        intent.putExtra(GAME_DIFFICULTY, gameDifficulty);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity_layout);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        int gameDifficulty = (int) getIntent().getSerializableExtra(GAME_DIFFICULTY);


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
        mGameFragment.setListener(this);
        mGameControllerFragment.setListener(this);
    }

    @Override
    public String updateTextView() {
        return mGameControllerFragment.displayBuilder();
    }

    @Override
    public String validateLetterGuess(char c) {
        return mGameControllerFragment.validateLetterGuess(c);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("End Game")
                .setMessage("Are you sure you want to end the game?")
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

    @Override
    public void setEndGameState() {
        mGameFragment.setEndGameState();
    }

    @Override
    public void alertActivityOfLoss() {

        AlertDialog.Builder builder = new AlertDialog.Builder (this);
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Oh Darn...You Lose")
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
        wmlp.x = 0;
        wmlp.y = 450;
        dialog.show();
    }

    @Override
    public void updateHangmanView(int sequence) {
        mGameFragment.updateHangmanDrawable(sequence);
    }
}
