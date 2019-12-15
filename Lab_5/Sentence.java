package com.company;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Sentence {
    protected ArrayList<SentenceElement> value;

    public Sentence() { this.value = new ArrayList<>(1); }
    public Sentence(Punctuation pm) {
        this.value = new ArrayList<>(1);
        value.add(pm);
    }

    public Sentence(ArrayList<SentenceElement> sentence) {
        this.value = new ArrayList<>(20);
        this.value.addAll(sentence.stream().collect(Collectors.toList()));
    }

    public ArrayList<SentenceElement> getValue() {
        return value;
    }

    @Override
    public String toString() {
        String result = "";
        for (SentenceElement se : value) {
            result += se;
        }
        return result;
    }

    public void add(Word word) {
        this.value.add(word);
    }

    public void add(Punctuation pm) {
        this.value.add(pm);
    }
}