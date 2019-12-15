package com.company;

public class SentenceElement {
    private String value;

    public SentenceElement() { this.value = ""; }

    public SentenceElement(String value) { this.value = value; }

    public SentenceElement(Word word) { setValue(word.getValue()); }

    public SentenceElement(Punctuation punctuation) {
        setValue(punctuation.getValue());
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}