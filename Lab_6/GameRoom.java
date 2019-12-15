package com.company;
import java.util.*;

public class GameRoom {
    private int ID;
    private static int maxID = 1;
    private String type;
    private int old;
    private int price;

    public GameRoom() {
        this.ID = maxID;
        maxID++;
        setType("");
        setOld(new Random().nextInt(16));
        setPrice(new Random().nextInt(5000));
    }
    public GameRoom(String type, int old, int price) {
        this.ID = maxID;
        maxID++;
        setType(type);
        setOld(old);
        setPrice(price);
    }

    public int getID() {
        return ID;
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

    public void printInfo() {
        System.out.print(ANSI_RED + String.format("%-4d", getID()) + ANSI_RESET +
                ANSI_YELLOW + String.format("%-17s", getType()) + ANSI_RESET +
                ANSI_CYAN + String.format("%-9d", getOld()) + ANSI_RESET +
                ANSI_GREEN  + String.format("%-10d", getPrice()) + ANSI_RESET +
                ANSI_PURPLE +String.format("%s", this.getClass().getSimpleName()) + ANSI_RESET);
    }

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
}