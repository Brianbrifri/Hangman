package edu.umsl.briankoehler.hangman;

import com.orm.SugarRecord;


public class GameWord extends SugarRecord{
    private String word;
    private int length;

    public GameWord() {

    }

    public GameWord(String word, int length) {
        this.word = word;
        this.length = length;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
