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
    private GameFragmentListener mListener;

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
    private Button mAButton;
    private Button mSButton;
    private Button mDButton;
    private Button mFButton;
    private Button mGButton;
    private Button mHButton;
    private Button mJButton;
    private Button mKButton;
    private Button mLButton;
    private Button mZButton;
    private Button mXButton;
    private Button mCButton;
    private Button mVButton;
    private Button mBButton;
    private Button mNButton;
    private Button mMButton;


    interface GameFragmentListener {
        String updateTextView();
    }

    public void setListener (GameFragmentListener listener) {
        mListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_layout, container, false);
        mQButton = (Button) view.findViewById(R.id.imageButtonQ);
        mQButton.setOnClickListener(letterGuess());
        mWButton = (Button) view.findViewById(R.id.imageButtonW);
        mWButton.setOnClickListener(letterGuess());
        mEButton = (Button) view.findViewById(R.id.imageButtonE);
        mEButton.setOnClickListener(letterGuess());
        mRButton = (Button) view.findViewById(R.id.imageButtonR);
        mRButton.setOnClickListener(letterGuess());
        mTButton = (Button) view.findViewById(R.id.imageButtonT);
        mTButton.setOnClickListener(letterGuess());
        mYButton = (Button) view.findViewById(R.id.imageButtonY);
        mYButton.setOnClickListener(letterGuess());
        mUButton = (Button) view.findViewById(R.id.imageButtonU);
        mUButton.setOnClickListener(letterGuess());
        mIButton = (Button) view.findViewById(R.id.imageButtonI);
        mIButton.setOnClickListener(letterGuess());
        mOButton = (Button) view.findViewById(R.id.imageButtonO);
        mOButton.setOnClickListener(letterGuess());
        mPButton = (Button) view.findViewById(R.id.imageButtonP);
        mPButton.setOnClickListener(letterGuess());
        mAButton = (Button) view.findViewById(R.id.imageButtonA);
        mAButton.setOnClickListener(letterGuess());
        mSButton = (Button) view.findViewById(R.id.imageButtonS);
        mSButton.setOnClickListener(letterGuess());
        mDButton = (Button) view.findViewById(R.id.imageButtonD);
        mDButton.setOnClickListener(letterGuess());
        mFButton = (Button) view.findViewById(R.id.imageButtonF);
        mFButton.setOnClickListener(letterGuess());
        mGButton = (Button) view.findViewById(R.id.imageButtonG);
        mGButton.setOnClickListener(letterGuess());
        mHButton = (Button) view.findViewById(R.id.imageButtonH);
        mHButton.setOnClickListener(letterGuess());
        mJButton = (Button) view.findViewById(R.id.imageButtonJ);
        mJButton.setOnClickListener(letterGuess());
        mKButton = (Button) view.findViewById(R.id.imageButtonK);
        mKButton.setOnClickListener(letterGuess());
        mLButton = (Button) view.findViewById(R.id.imageButtonL);
        mLButton.setOnClickListener(letterGuess());
        mZButton = (Button) view.findViewById(R.id.imageButtonZ);
        mZButton.setOnClickListener(letterGuess());
        mXButton = (Button) view.findViewById(R.id.imageButtonX);
        mXButton.setOnClickListener(letterGuess());
        mCButton = (Button) view.findViewById(R.id.imageButtonC);
        mCButton.setOnClickListener(letterGuess());
        mVButton = (Button) view.findViewById(R.id.imageButtonV);
        mVButton.setOnClickListener(letterGuess());
        mBButton = (Button) view.findViewById(R.id.imageButtonB);
        mBButton.setOnClickListener(letterGuess());
        mNButton = (Button) view.findViewById(R.id.imageButtonN);
        mNButton.setOnClickListener(letterGuess());
        mMButton = (Button) view.findViewById(R.id.imageButtonM);
        mMButton.setOnClickListener(letterGuess());
        mWordTextView = (TextView) view.findViewById(R.id.main_text_view);

        updateTextView();

        return view;
    }

    public void updateTextView() {
        mWordTextView.setText(mListener.updateTextView());
    }

    private View.OnClickListener letterGuess() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imageButtonA:

                }
            }
        };
    }
}
