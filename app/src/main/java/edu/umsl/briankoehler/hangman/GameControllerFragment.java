package edu.umsl.briankoehler.hangman;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * Created by b-kizzle on 5/7/16.
 */
public class GameControllerFragment extends Fragment{

    private GameModel mGameModel;
    private int numberOfUnguessedLetters;
    private int numberOfBadGuessesLeft;
    private ArrayList<String> listOfPlaceHolders;


    private String secretWord;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        int difficultyLevel = args.getInt("difficulty", 0);
        mGameModel = new GameModel(difficultyLevel);
        secretWord = mGameModel.getWord();
        arrayInitializer(secretWord);

        if (difficultyLevel == 0) {
            numberOfBadGuessesLeft = 12;
        }
        else if (difficultyLevel == 1) {
            numberOfBadGuessesLeft = 9;
        }
        else {
            numberOfBadGuessesLeft = 7;
        }
    }




    private void arrayInitializer(String theWord) {
        listOfPlaceHolders = new ArrayList<>();
        numberOfUnguessedLetters = theWord.length();
        for (int i = 0; i < theWord.length(); i++) {
            listOfPlaceHolders.add("_");
        }
    }



    public String displayBuilder() {
        String displayString;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < listOfPlaceHolders.size(); i++) {
            builder.append(listOfPlaceHolders.get(i)).append(" ");
        }
        displayString = builder.toString();
        return displayString;
    }

    public String validateLetterGuess(char c) {
        boolean badGuess = true;
        numberOfUnguessedLetters = 0;
        for (int i = 0; i < secretWord.length(); i++) {
            if (c == secretWord.charAt(i)) {
                String temp = String.valueOf(c);
                temp = temp.toUpperCase();
                listOfPlaceHolders.set(i, temp);
                badGuess = false;
            }
        }

        if (badGuess) {
            numberOfBadGuessesLeft--;
        }

        for (int i = 0; i < listOfPlaceHolders.size(); i++) {
            if (listOfPlaceHolders.get(i).equals("_")) {
                numberOfUnguessedLetters++;
            }
        }

        //Win scenario
        if (numberOfUnguessedLetters == 0) {
            //TODO write code for game win
        }

        //Lose scenario
        if (numberOfUnguessedLetters > 0 && numberOfBadGuessesLeft == 0) {
            for (int i = 0; i < secretWord.length(); i++) {
                String temp = String.valueOf(secretWord.charAt(i));
                temp = temp.toUpperCase();
                listOfPlaceHolders.set(i, temp);
            }
        }
        return displayBuilder();
    }
}
