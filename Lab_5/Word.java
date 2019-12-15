package com.company;
import java.util.ArrayList;

public class Word extends SentenceElement implements Comparable<Word> {
    private ArrayList<Letter> value;
    public static final char[] vowels = {'e'};

    public Word() { this.value = new ArrayList<>(1); }

    public Word(String word) {
        try {
            setValue(word);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getValue() {
        String result = "";
        for (Letter letter : value) {
            result += letter.getValue();
        }
        return result;
    }

    @Override
    public void setValue(String value) {
        this.value = new ArrayList<>(value.length());
        for (char c : value.toCharArray()) {
            this.value.add(new Letter(c));
        }
    }

    @Override
    public String toString() { return getValue(); }

    public int countVowels() {
        int count = 0;
        for (char c : this.getValue().toCharArray()) {
            char cLower = Character.toLowerCase(c);
            for (char vowel : vowels) {
                if (cLower == vowel) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    @Override
    public int compareTo(Word other) {
        int vowelsDiff = other.countVowels() - this.countVowels();
        if (vowelsDiff != 0) {
            return vowelsDiff;
        }
        return this.getValue().compareTo(other.getValue());
    }

    public void add(char c) {
        setValue(getValue() + c);
    }
}