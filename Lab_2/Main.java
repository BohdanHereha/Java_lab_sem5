package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int i, j;
        try {
            System.out.print("Введіть i: ");
            i = input.nextInt();
            System.out.print("Введіть j: ");
            j = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ви можете вводити тільки число!");
            return;
        }

        if (i <= 0 || j <= 0) {
            System.out.println("i та j можуть набувати тільки додатніх значень!");
            return;
        }

        long[][] matrixB;
        long[] arrB;
        matrixB = new long[i][j];
        arrB = new long[i];

        //Генерація матриці
        for (i=0; i < matrixB.length; i++){
            for (j=0; j < matrixB[i].length; j++){
                matrixB[i][j]=(long)(Math.random()*40);
            }
        }

        print_matrix(matrixB);
        System.out.println("Матриця помножена на константу");
        multiplication(matrixB,5);
        print_matrix(matrixB);
        System.out.println("Масив мінімальних елементів: ");
        minElemMatrix(matrixB, arrB);
        sumMinElemMatrix(arrB);
    }
    //Вивід матриці
    private static void print_matrix (long[][] matrixB) {
        for (int i = 0; i < matrixB.length; i++){
            for (int j = 0; j < matrixB[i].length; j++){
                System.out.print(matrixB[i][j]+ "\t");
            }
            System.out.println();
        }
    }

    //Множення матриці на константу
    private static void multiplication (long[][] matrixB, int a) {
        for (int i = 0; i < matrixB.length; i++){
            for (int j=0;j < matrixB[i].length; j++){
                matrixB[i][j] *= a;
            }
        }
    }

    private static void minElemMatrix (long[][] matrixB, long[] arrB) {
        for(int i = 0; i < matrixB.length; i++ ) {
            arrB[i]=matrixB[i][0];   // ініціалізація матриці мінімальних елементів
        }
        for(int i = 0; i < matrixB.length; i++ ) {
            for(int j = 1 ;j < matrixB[i].length ; j++ ) {
                if(arrB[i]>matrixB[i][j])
                    arrB[i]=matrixB[i][j];
            }
            System.out.print(arrB[i]+ " ");
        }
        System.out.print("\n");
    }

	// Додавання мінімальних елеменів
    private static void sumMinElemMatrix(long[] arrB)
    {
        long sum = 0L;
        for(int i = 0; i < arrB.length; i++ ) {
            sum += arrB[i];
        }
        System.out.println("Сума найменших елементів кожного рядка матриці становить: " + sum);
    }

}