package com.company;

public class Letter {
    private char value;

    public Letter() { }

    public Letter(char value) {
        try {
            setValue(value);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) throws IllegalArgumentException {
        if (Character.isLetter(value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Not a letter");
        }
    }
}
