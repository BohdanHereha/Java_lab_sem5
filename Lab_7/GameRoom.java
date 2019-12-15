package com.company;

import java.util.*;

public class GameRoom {
    private String type;
    private int old;
    private int price;

    public GameRoom() {
        setType("");
        setOld(new Random().nextInt(16));
        setPrice(new Random().nextInt(5000));
    }

    public GameRoom(String type, int old, int price) {
        setType(type);
        setOld(old);
        setPrice(price);
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String string = "\nType of toy: " + getType() + "\nFor kids ages from: " + getOld() + "\nPrice: " + getPrice();
        return string;
    }
}