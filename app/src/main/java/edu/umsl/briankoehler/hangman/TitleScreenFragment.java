package edu.umsl.briankoehler.hangman;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Brian Koehler on 4/25/2016.
 */
public class TitleScreenFragment extends Fragment{
    private Button mEasyButton;
    private Button mMediumButton;
    private Button mHardButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_title_layout, container, false);
        mEasyButton = (Button) view.findViewById(R.id.easy_button);
        mMediumButton = (Button) view.findViewById(R.id.medium_button);
        mHardButton = (Button) view.findViewById(R.id.hard_button);
        return view;
    }
}
