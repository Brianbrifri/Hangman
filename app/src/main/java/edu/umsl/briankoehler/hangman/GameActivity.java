package edu.umsl.briankoehler.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by b-kizzle on 5/4/16.
 */
public class GameActivity extends AppCompatActivity implements GameFragment.GameFragmentListener{

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
    }

    @Override
    public String updateTextView() {
        return mGameControllerFragment.displayBuilder();
    }

    @Override
    public String validateLetterGuess(char c) {
        return mGameControllerFragment.validateLetterGuess(c);
    }
}
