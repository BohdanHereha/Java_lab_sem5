package com.company;

public class Punctuation extends SentenceElement {
    private char value;
    public static final char[] textDelimiters = {'.', '!', '?', '\n'};
    public static final char[] sentenceDelimiters = {' ', ',', ':', ';', '-', '(', ')', '\'', '"', '«', '»'};

    public Punctuation() {
        super();
        setValue("\0");
    }

    public Punctuation(char c) {
        this.value = c;
    }

    public Punctuation(String punctuation) {
        super(punctuation);
        try {
            setValue(punctuation);
        } catch (IllegalArgumentException e) {
            System.out.printf("\n", e, punctuation);
        }
    }

    @Override
    public String getValue() {
        if (super.getValue().length() > 1) {
            return "";
        } else {
            return String.valueOf(this.value);
        }
    }

    @Override
    public void setValue(String value) throws IllegalArgumentException {
        switch (value.length()) {
            case 1:
                this.value = value.charAt(0);
                break;
            case 0:
                throw new IllegalArgumentException("Empty punctuation mark");
            default:
                // Punctuation's length is >1 so it'll be ignored
                throw new IllegalArgumentException("Incorrect punctuation mark");
        }
    }

    @Override
    public String toString() {
        return getValue();
    }
}