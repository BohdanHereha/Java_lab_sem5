package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char a, b, m, n;
        double result = 0 ;

        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter a : ");
            a = input.next(".").charAt(0);
            System.out.print("Enter b : ");
            b = input.next(".").charAt(0);
            System.out.print("Enter m : ");
            m = input.next(".").charAt(0);
            System.out.print("Enter n : ");
            n = input.next(".").charAt(0);
            input.close();
        } catch (Exception e) {
            System.out.print("You can only enter one symbol");
            return;
        }

        int a1=Character.getNumericValue(a);
        int b1=Character.getNumericValue(b);
        int n1=Character.getNumericValue(n);
        int m1=Character.getNumericValue(m);

        System.out.println("a = "+a1);
        System.out.println("b = "+b1);
        System.out.println("n = "+n1);
        System.out.println("m = "+m1);

        if(a1 > n1 || b1 > m1) {
            System.out.println("The upper bound must be greater than the lower bound. Cannot calculate. ");
        } else {
            try {
                for (int i = a1; i <= n1; i++) {
                    for (int j = b1; j <= m1; j++) {
                        result += i * j / i;
                    }
                }
                System.out.println("Result = "+result);
            } catch (Exception e) {
                System.out.println("Division by zero exception");
            }
        }
    }
}