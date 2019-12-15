package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("The StringBuilder in Java represents a mutable sequence of characters. " +
                "Since the String Class in Java creates an immutable sequence of characters, the StringBuilder class " +
                "provides an alternative to String Class, as it creates a mutable sequence of characters. The function " +
                "of StringBuilder is very much similar to the StringBuffer class, as both of them provide an alternative" +
                " to String Class by making a mutable sequence of characters.");

        String[] array = text.toString().split("[!. ,?;:()]+",0);
        int[] countArray = new int[array.length];
        char letter = 'e';
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length(); j++) {
                if (array[i].toLowerCase().charAt(j) == letter) { //возвращает символ, расположенный по указанному индексу строки
                    countArray[i] += 1;
                }
            }
        }

        System.out.println(Arrays.toString(countArray));

        for (int i = 0; i < countArray.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (countArray[j] < countArray[i]) {
                    int temp = countArray[i];
                    countArray[i] = countArray[j];
                    countArray[j] = temp;

                    String tempSTR = array[i];
                    array[i] = array[j];
                    array[j] = tempSTR;
                }
            }
        }

        System.out.println(Arrays.toString(countArray));

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\n");
        }
    }
}
