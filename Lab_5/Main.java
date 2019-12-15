package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        StringBuilder someText = new StringBuilder("The StringBuilder in Java represents a mutable sequence of characters. " +
                "Since the String Class in Java creates an immutable sequence of characters, the StringBuilder class " +
                "provides an alternative to String Class, as it creates a mutable sequence of characters. The function " +
                "of StringBuilder is very much similar to the StringBuffer class, as both of them provide an alternative" +
                " to String Class by making a mutable sequence of characters.");

        Text text = parseStringToText(someText.toString());
        //System.out.println(text);
        ArrayList<Word> words = getWords(text);
        Collections.sort(words);
        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i) + "\n");
        }
    }

    public static Text parseStringToText(String text) throws IllegalArgumentException {
        if (text.equals("")) {
            throw new IllegalArgumentException("Empty text on input");
        }
        int numberOfSentences = countMatches(text, Punctuation.textDelimiters);
        ArrayList<Sentence> result = new ArrayList<>(numberOfSentences);
        char currentChar;
        Word lastWord = new Word();
        Punctuation lastPM = new Punctuation();
        Sentence lastSentence = new Sentence();

        for (int i = 0; i < text.length(); i++) {
            currentChar = text.charAt(i);
            if (Character.isLetter(currentChar)) {
                lastWord.add(currentChar);
            } else if (isDelimiter(currentChar, Punctuation.sentenceDelimiters)) {
                lastPM.setValue(String.valueOf(currentChar));
                lastSentence.add(new Word(lastWord.getValue()));
                lastSentence.add(new Punctuation(lastPM.getValue()));
                lastWord.setValue("");
            } else if (isDelimiter(currentChar, Punctuation.textDelimiters)) {
                lastPM.setValue(String.valueOf(currentChar));
                lastSentence.add(new Word(lastWord.getValue()));
                lastWord.setValue("");
                lastSentence.add(new Punctuation(lastPM.getValue()));
                result.add(new Sentence(lastSentence.getValue()));
                lastSentence.value.clear();
            } else { }
        }
        return new Text(result);
    }

    public static boolean isDelimiter(char c, char[] delimiters) {
        return new String(delimiters).indexOf(c) != -1;
    }

    public static int countMatches(String text, char[] delimiterCharsSequence) {
        int result = 0;
        for (char c : text.toCharArray()) {
            for (char delimiter : delimiterCharsSequence) {
                if (c == delimiter) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public static ArrayList<Word> getWords(Text text) {
        ArrayList<Word> result = new ArrayList<>(2000); // depends on text
        for (Sentence s : text.getValue()) {
            result.addAll(s.getValue().stream()
                    .filter(se -> se instanceof Word && !se.getValue().equals(""))
                    .map(se -> new Word(se.getValue()))
                    .collect(Collectors.toList()));
        }
        return result;
    }
}
