package edu.umsl.briankoehler.hangman;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by b-kizzle on 5/7/16.
 */
public class GameModel {
    private GameWord mGameWord;
    private ArrayList<GameWord> mWordList;
    private static final int EASY = 0;
    private static final int MEDIUM = 1;
    private static final int HARD = 2;


    public GameModel(int difficultyLevel) {
        if (difficultyLevel == EASY) {
            mWordList = (ArrayList<GameWord>) GameWord.findWithQuery(GameWord.class, "Select * from game_word WHERE (length > 2 AND length < 6");
        }
        else if (difficultyLevel == MEDIUM) {
            mWordList = (ArrayList<GameWord>) GameWord.findWithQuery(GameWord.class, "Select * from game_word WHERE (length > 5 AND length < 8");
        }
        else {
            mWordList = (ArrayList<GameWord>) GameWord.findWithQuery(GameWord.class, "Select * from game_word WHERE (length > 7 AND length < 13");
        }

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mWordList.size() - 1);
        mGameWord = mWordList.get(randomNumber);
        Log.d("TAG", "Index chosen is: " + randomNumber + ". Word selected is: " + mGameWord.getWord());
    }

    public int getSizeOfWord() {
        return mGameWord.getLength();
    }

    public String getWord() {
        return mGameWord.getWord();
    }
}
