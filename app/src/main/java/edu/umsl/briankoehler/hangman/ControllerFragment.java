package edu.umsl.briankoehler.hangman;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class ControllerFragment extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void addWordsFromFileToDb() {
        BufferedReader bufferedReader = null;
        AssetManager manager = getContext().getAssets();

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(manager.open("dictionary.txt")));

            String word;
            while((word = bufferedReader.readLine()) != null) {
                GameWord gameWord = new GameWord(word, word.length());
                gameWord.save();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bufferedReader.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }


}
