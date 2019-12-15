package com.company;
import java.util.ArrayList;

public class Text {
    private ArrayList<Sentence> value;

    public Text() { this.value = new ArrayList<>(1); }

    public Text(ArrayList<Sentence> sentenceArrayList) { this.value = sentenceArrayList; }

    public ArrayList<Sentence> getValue() { return value; }

    @Override
    public String toString() {
        String result = "";
        for (Sentence sentence : value) {
            result += sentence;
        }
        return result;
    }
}