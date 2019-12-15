package com.company;

import java.util.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        GameRoom[] toys = new GameRoom[9];

        toys[0] = new Small("Doll", 5, 293);
        toys[1] = new Small("Spinner", 7, 334);
        toys[2] = new Small("Mobile phone", 10, 121);

        toys[3] = new Middle("Grasshopper", 7, 609);
        toys[4] = new Middle("Elephant", 12, 458);
        toys[5] = new Middle("Sponge Bob", 9, 385);

        toys[6] = new Big("Car", 14, 1235);
        toys[7] = new Big("Motorbike", 13, 1006);
        toys[8] = new Big("Airplane", 12, 1108);

        printHeader("null");
        printTrackList(toys);

        printHeader("Ціною");
        Arrays.sort(toys, new SortedByPrice());
        printTrackList(toys);

        printHeader("Типом");
        Arrays.sort(toys, new SortedByType());
        printTrackList(toys);

        Scanner scanner = new Scanner(System.in);
        int minPrice, maxPrice;
        try {
            System.out.print("\nВкажіть мінімальну ціну: ");
            minPrice = scanner.nextInt();
            System.out.print("Вкажіть максимальну ціну: ");
            maxPrice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ви можете вводити тільки число!");
            return;
        }

        if (minPrice < 0 || maxPrice < 0) {
            System.out.println("Ціна не може бути відємною!");
            return;
        }
        if (minPrice > maxPrice) {
            System.out.println("Мінімальна ціна не може бути більшою за максимальну!");
            return;
        }

        GameRoom[] filteredCompositions = searchByToyPrice(minPrice, maxPrice, toys);
        System.out.printf("\nВибірка: з %d по %d\n", minPrice, maxPrice);
        printHeader("filter");
        printTrackList(filteredCompositions);
    }

    //Print header
    public static void printHeader(String criteria) {
        final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        final String ANSI_RESET = "\u001B[0m";
        if (Objects.equals(criteria, "null")) {
            System.out.printf("\n" + ANSI_YELLOW_BACKGROUND + "------------------ %s ------------------" +
                    ANSI_RESET + "\n", "Не відсортовано");
        } else if (Objects.equals(criteria, "filter")) {
            System.out.printf("\n" + ANSI_YELLOW_BACKGROUND + "-------------------- %s --------------------" +
                    ANSI_RESET + "\n", "Вибірка");
        } else {
            System.out.printf("\n" + ANSI_CYAN_BACKGROUND + "---------------- %s %s ----------------" +
                    ANSI_RESET + "\n", "Відсортовано за", criteria);
        }
        System.out.printf("%-3s %-16s %-8s %-9s %s\n", "ID", "Тип", "Вік", "Ціна", "Розмір");
    }

    static void printTrackList(GameRoom[] toys) {
        for (int i = 0; i < toys.length; i++) {
            toys[i].printInfo();
            System.out.println();
        }
    }

    // Sort by price
    static class SortedByPrice implements Comparator<GameRoom> {
        public int compare(GameRoom obj1, GameRoom obj2) {
            int var1 = obj1.getPrice();
            int var2 = obj2.getPrice();
            return var1 - var2;
        }

    }

    // Sort by title
    static class SortedByType implements Comparator<GameRoom> {
        public int compare(GameRoom obj1, GameRoom obj2) {
            String str1 = obj1.getType();
            String str2 = obj2.getType();
            return str1.compareTo(str2);
        }
    }

    // Search in track list
    public static GameRoom[] searchByToyPrice(int minPrice, int maxPrice, GameRoom[] src) {
        ArrayList<GameRoom> result = new ArrayList<>(src.length);
        for (int i = 0; i < src.length; i++) {
            if (src[i].getPrice() > minPrice && src[i].getPrice() < maxPrice) {
                result.add(src[i]);
            }
        }
        return result.toArray(new GameRoom[]{});
    }
}