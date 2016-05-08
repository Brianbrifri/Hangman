package edu.umsl.briankoehler.hangman;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by b-kizzle on 5/7/16.
 */
public class GameControllerFragment extends Fragment{

    private GameModel mGameModel;
    private String secretWord;
    private int secretWordLength;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        int difficultyLevel = args.getInt("difficulty", 0);
        mGameModel = new GameModel(difficultyLevel);
        secretWord = mGameModel.getWord();
        secretWordLength = mGameModel.getSizeOfWord();
    }

    public int getWordLength() {
        return secretWordLength;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
