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
    private ArrayList<String> listOfPlaceHolders;

    private String aPlaceHolder;
    private String bPlaceHolder;
    private String cPlaceHolder;
    private String dPlaceHolder;
    private String ePlaceHolder;
    private String fPlaceHolder;
    private String gPlaceHolder;
    private String hPlaceHolder;
    private String iPlaceHolder;
    private String jPlaceHolder;
    private String kPlaceHolder;
    private String lPlaceHolder;
    private String mPlaceHolder;
    private String nPlaceHolder;
    private String oPlaceHolder;
    private String pPlaceHolder;
    private String qPlaceHolder;
    private String rPlaceHolder;
    private String sPlaceHolder;
    private String tPlaceHolder;
    private String uPlaceHolder;
    private String vPlaceHolder;
    private String wPlaceHolder;
    private String xPlaceHolder;
    private String yPlaceHolder;
    private String zPlaceHolder;
    private String secretWord;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        int difficultyLevel = args.getInt("difficulty", 0);
        mGameModel = new GameModel(difficultyLevel);
        secretWord = mGameModel.getWord();
        initializePlaceHolders();
        arrayInitializer(secretWord);
    }


    private void initializePlaceHolders() {
        aPlaceHolder = "_";
        bPlaceHolder = "_";
        cPlaceHolder = "_";
        dPlaceHolder = "_";
        ePlaceHolder = "_";
        fPlaceHolder = "_";
        gPlaceHolder = "_";
        hPlaceHolder = "_";
        iPlaceHolder = "_";
        jPlaceHolder = "_";
        kPlaceHolder = "_";
        lPlaceHolder = "_";
        mPlaceHolder = "_";
        nPlaceHolder = "_";
        oPlaceHolder = "_";
        pPlaceHolder = "_";
        qPlaceHolder = "_";
        rPlaceHolder = "_";
        sPlaceHolder = "_";
        tPlaceHolder = "_";
        uPlaceHolder = "_";
        vPlaceHolder = "_";
        wPlaceHolder = "_";
        xPlaceHolder = "_";
        yPlaceHolder = "_";
        zPlaceHolder = "_";
    }

    private void arrayInitializer(String theWord) {
        listOfPlaceHolders = new ArrayList<>();
        for (int i = 0; i < theWord.length(); i++) {
            char c = theWord.charAt(i);

            switch (c) {
                case 'a':
                    listOfPlaceHolders.add(aPlaceHolder);
                    break;
                case 'b':
                    listOfPlaceHolders.add(bPlaceHolder);
                    break;
                case 'c':
                    listOfPlaceHolders.add(cPlaceHolder);
                    break;
                case 'd':
                    listOfPlaceHolders.add(dPlaceHolder);
                    break;
                case 'e':
                    listOfPlaceHolders.add(ePlaceHolder);
                    break;
                case 'f':
                    listOfPlaceHolders.add(fPlaceHolder);
                    break;
                case 'g':
                    listOfPlaceHolders.add(gPlaceHolder);
                    break;
                case 'h':
                    listOfPlaceHolders.add(hPlaceHolder);
                    break;
                case 'i':
                    listOfPlaceHolders.add(iPlaceHolder);
                    break;
                case 'j':
                    listOfPlaceHolders.add(jPlaceHolder);
                    break;
                case 'k':
                    listOfPlaceHolders.add(kPlaceHolder);
                    break;
                case 'l':
                    listOfPlaceHolders.add(lPlaceHolder);
                    break;
                case 'm':
                    listOfPlaceHolders.add(mPlaceHolder);
                    break;
                case 'n':
                    listOfPlaceHolders.add(nPlaceHolder);
                    break;
                case 'o':
                    listOfPlaceHolders.add(oPlaceHolder);
                    break;
                case 'p':
                    listOfPlaceHolders.add(pPlaceHolder);
                    break;
                case 'q':
                    listOfPlaceHolders.add(qPlaceHolder);
                    break;
                case 'r':
                    listOfPlaceHolders.add(rPlaceHolder);
                    break;
                case 's':
                    listOfPlaceHolders.add(sPlaceHolder);
                    break;
                case 't':
                    listOfPlaceHolders.add(tPlaceHolder);
                    break;
                case 'u':
                    listOfPlaceHolders.add(uPlaceHolder);
                    break;
                case 'v':
                    listOfPlaceHolders.add(vPlaceHolder);
                    break;
                case 'w':
                    listOfPlaceHolders.add(wPlaceHolder);
                    break;
                case 'x':
                    listOfPlaceHolders.add(xPlaceHolder);
                    break;
                case 'y':
                    listOfPlaceHolders.add(yPlaceHolder);
                    break;
                case 'z':
                    listOfPlaceHolders.add(zPlaceHolder);
                    break;
                default:
                    break;
            }
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
}
