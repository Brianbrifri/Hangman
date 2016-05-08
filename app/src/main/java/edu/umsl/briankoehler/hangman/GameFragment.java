package edu.umsl.briankoehler.hangman;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Brian Koehler on 5/4/2016.
 */
public class GameFragment extends Fragment{

    private TextView mWordTextView;

    private Button mQButton;
    private Button mWButton;
    private Button mEButton;
    private Button mRButton;
    private Button mTButton;
    private Button mYButton;
    private Button mUButton;
    private Button mIButton;
    private Button mOButton;
    private Button mPButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_layout, container, false);
        mQButton = (Button) view.findViewById(R.id.imageButtonQ);
        mWButton = (Button) view.findViewById(R.id.imageButtonW);
        mEButton = (Button) view.findViewById(R.id.imageButtonE);
        mRButton = (Button) view.findViewById(R.id.imageButtonR);
        mTButton = (Button) view.findViewById(R.id.imageButtonT);
        mYButton = (Button) view.findViewById(R.id.imageButtonY);
        mUButton = (Button) view.findViewById(R.id.imageButtonU);
        mIButton = (Button) view.findViewById(R.id.imageButtonI);
        mOButton = (Button) view.findViewById(R.id.imageButtonO);
        mPButton = (Button) view.findViewById(R.id.imageButtonP);
        mWordTextView = (TextView) view.findViewById(R.id.main_text_view);

        return view;
    }

    public void updateTextView(String currentWordDisplay) {
        mWordTextView.setText("Test");
    }
}
