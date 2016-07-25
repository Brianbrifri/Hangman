package edu.umsl.briankoehler.hangman;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by b-kizzle on 5/7/16.
 */
public class GameControllerFragment extends Fragment{

    private GameModel mGameModel;
    private int numberOfUnguessedLetters;
    private int numberOfBadGuessesLeft;
    private int numberOfBadGuessesMade;
    private int difficultyLevel;
    private ArrayList<String> listOfPlaceHolders;
    private String secretWord;
    private listener mListener;

    //Listener interface and methods
    interface listener {
        void setEndGameState();
        void alertActivityOfLoss();
        void alertActivityOfWin();
        void updateHangmanView(int sequence);
    }

    public void setListener(listener listener) {
        mListener = listener;
    }

    //The on create news up a game model and gets the word returned from it
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Gets the arguments bundled in the activity so it knows
        //what difficulty level it is
        Bundle args = getArguments();
        difficultyLevel = args.getInt("difficulty", 0);
        mGameModel = new GameModel(difficultyLevel);
        secretWord = mGameModel.getWord();
        arrayInitializer(secretWord);


    }



    //This initializes the array with as many "_" as there are number of letters in the word
    //Also sets the number of bad guesses left based on the difficulty level
    private void arrayInitializer(String theWord) {
        listOfPlaceHolders = new ArrayList<>();
        numberOfUnguessedLetters = theWord.length();
        numberOfBadGuessesMade = 0;
        for (int i = 0; i < theWord.length(); i++) {
            listOfPlaceHolders.add("_");
        }

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



    //Returns a string based on what is in the listOfPlaceHolders array
    //This is exactly what is displayed on the screen
    public String displayBuilder() {
        String displayString;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < listOfPlaceHolders.size(); i++) {
            builder.append(listOfPlaceHolders.get(i)).append(" ");
        }
        displayString = builder.toString();
        return displayString;
    }

    //This gets called by the activity via a listener from the view fragment
    //It gets a char, checks it against the letters in the word, the updates the
    //listOfPaceHolders if the guess matches any
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

        //If it was a bad guess, decrement the number of bad guesses left
        if (badGuess) {
            numberOfBadGuessesLeft--;

            //If it's a bad guess, increment the number of them made
            //which corresponds to which drawable should be displayed
            //Increment sequence evenly for easy level
            if (difficultyLevel == 0) {
                numberOfBadGuessesMade++;
            }
            //Increment sequence with a couple jumps
            //for medium level
            if (difficultyLevel == 1) {
                if (numberOfBadGuessesMade == 0) {
                    numberOfBadGuessesMade =+ 2;
                }
                else if (numberOfBadGuessesMade == 7) {
                    numberOfBadGuessesMade += 2;
                }

                else if (numberOfBadGuessesMade == 9) {
                    numberOfBadGuessesMade += 2;
                }
                else {
                    numberOfBadGuessesMade++;
                }
            }
            //Increment sequence much rapidly for hard level
            if (difficultyLevel == 2) {
                if (numberOfBadGuessesMade == 0) {
                    numberOfBadGuessesMade += 2;
                }
                else if (numberOfBadGuessesMade == 3) {
                    numberOfBadGuessesMade += 2;
                }
                else if (numberOfBadGuessesMade == 5) {
                    numberOfBadGuessesMade += 2;
                }
                else if (numberOfBadGuessesMade == 7) {
                    numberOfBadGuessesMade += 2;
                }
                else if (numberOfBadGuessesMade == 9) {
                    numberOfBadGuessesMade += 2;
                }
                else {
                    numberOfBadGuessesMade++;
                }
            }
            mListener.updateHangmanView(numberOfBadGuessesMade);
        }

        for (int i = 0; i < listOfPlaceHolders.size(); i++) {
            if (listOfPlaceHolders.get(i).equals("_")) {
                numberOfUnguessedLetters++;
            }
        }

        //Win scenario
        if (numberOfUnguessedLetters == 0) {
            mListener.alertActivityOfWin();
            mListener.setEndGameState();
        }

        //Lose scenario
        if (numberOfUnguessedLetters > 0 && numberOfBadGuessesLeft == 0) {
            for (int i = 0; i < secretWord.length(); i++) {
                String temp = String.valueOf(secretWord.charAt(i));
                temp = temp.toUpperCase();
                listOfPlaceHolders.set(i, temp);
            }
            mListener.setEndGameState();
            mListener.alertActivityOfLoss();
        }
        return displayBuilder();
    }

    //Resets everything and gets new word
    public String resetGame() {
        mGameModel = new GameModel(difficultyLevel);
        secretWord = mGameModel.getWord();
        arrayInitializer(secretWord);
        return displayBuilder();
    }
}
