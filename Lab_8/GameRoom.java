package com.company;

import java.util.*;

public class GameRoom {
    private String type;
    private int old;
    private int price;

    public GameRoom() {
        if (isValid(type, old, price)) {
            setType("");
            setOld(new Random().nextInt(16));
            setPrice(new Random().nextInt(5000));
        } else {
            throw new GameRoomException("Invalid parameters for the music track.");
        }
    }


    public GameRoom(String type, int old, int price) {
        if (isValid(type, old, price)) {
            setType(type);
            setOld(old);
            setPrice(price);
        } else {
            throw new GameRoomException("Invalid parameters for the music track.");
        }
    }

    private boolean isValid(String type, int old, int price) {
        return type.length() > 0 && old > 0 && price > 0;
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

    @Override
    public boolean equals(final Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj instanceof GameRoom) {
            GameRoom g = (GameRoom) obj;
            return g.getType().equals(this.getType())
                    && g.getOld() == this.getOld()
                    && g.getPrice() == (this.getPrice());

        }
        return false;
    }

    @Override
    public int hashCode() {
        return type.hashCode() + ((Integer) old).hashCode()
                + ((Integer) price).hashCode();
    }
}