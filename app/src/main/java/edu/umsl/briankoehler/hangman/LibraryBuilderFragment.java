package edu.umsl.briankoehler.hangman;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class LibraryBuilderFragment extends Fragment{

    private listener mListener;

    //Listener interface
    interface listener {
        void onUpdateComplete();
        void updateProgressBar(int progress);
    }

    public void setListener(listener listener) {
        mListener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    //Creates a buffered reader to read in words from text file in assets folder.
    //Make an ArrayList of those words then adds those words, along with their length,
    //to the database
    public void addWordsFromFileToDb() {
        BufferedReader bufferedReader = null;
        AssetManager manager = getContext().getAssets();
        ArrayList<String> list = new ArrayList<>();
        GameWord gameWord;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(manager.open("dictionary.txt")));

            String word;
            while((word = bufferedReader.readLine()) != null) {
                list.add(word);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            assert bufferedReader != null;
            bufferedReader.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            if(i % 13 == 0) {
                gameWord = new GameWord(list.get(i), list.get(i).length());
                gameWord.save();
            }
            //Updates progress bar in title fragment
            mListener.updateProgressBar((i/list.size() * 10));
        }

        //Notifies title fragment that database is complete
        mListener.onUpdateComplete();
    }


}
