package edu.umsl.briankoehler.hangman;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by b-kizzle on 5/4/16.
 */
public class GameActivity extends AppCompatActivity{

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

        int gameDifficulty = (int) getIntent().getSerializableExtra(GAME_DIFFICULTY);

        FragmentManager manager = getSupportFragmentManager();
        mGameFragment = (GameFragment) manager.findFragmentById(R.id.fragment_container2);
        if(mGameFragment == null) {
            mGameFragment = new GameFragment();
            manager.beginTransaction()
                    .add(R.id.fragment_container2, mGameFragment)
                    .commit();
        }

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

        mGameFragment.updateTextView("Test");

    }
}
