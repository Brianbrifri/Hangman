package edu.umsl.briankoehler.hangman;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Brian Koehler on 4/25/2016.
 */
public class ControllerFragment extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
}
