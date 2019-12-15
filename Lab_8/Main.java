package com.company;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySet gameRoomSet = new MySet();
        MySet gameRoomSet1 = new MySet(new GameRoom("Spiner", 9, 125));
        System.out.println("Чи є порожньою: " + gameRoomSet.isEmpty());
        System.out.println("gameRoomSet1 " + Arrays.toString(gameRoomSet1.toArray()));

        GameRoom obj1 = new GameRoom("Spiner", 9, 125);
        GameRoom obj2 = new GameRoom("Tiger", 7, 90);
        GameRoom obj3 = new GameRoom("Car", 12, 250);
        GameRoom obj4 = new GameRoom("Doll", 4, 230);
        GameRoom obj5 = new GameRoom("Sponge Bob", 3, 150);
        GameRoom obj6 = new GameRoom("Mobile phone", 10, 400);
        GameRoom obj7 = new GameRoom("Airplane", 10, 345);

        gameRoomSet.add(obj1);
        gameRoomSet.add(obj2);
        gameRoomSet.add(obj3);
        gameRoomSet.add(obj4);
        gameRoomSet.add(obj5);
        gameRoomSet.add(obj6);
        gameRoomSet.add(obj7);

        System.out.println("Чи містить колекція об'єкт obj1: " + gameRoomSet.contains(obj1));
        System.out.println("Чи містить колекція об'єкт, якого не має: " + gameRoomSet.contains(new GameRoom("Motobike", 12, 370)));
        System.out.println("-------------------------------");

        MySet firstMySet = new MySet();
        MySet secondMySet = new MySet();

        firstMySet.add(obj1);
        firstMySet.add(obj2);
        firstMySet.add(obj3);
        firstMySet.add(obj4);
        firstMySet.add(obj5);

        secondMySet.add(obj1);
        secondMySet.add(obj2);
        secondMySet.add(obj4);
        secondMySet.add(obj6);
        secondMySet.add(obj7);

        System.out.print("firstMySet\n" + Arrays.toString(firstMySet.toArray()) + "\n");
        System.out.println("-------------------------------");
        System.out.print("secondMySet\n" + Arrays.toString(secondMySet.toArray()) + "\n");
        System.out.println("-------------------------------");
        firstMySet.retainAll(secondMySet);
        System.out.print("firstMySet.retainAll(secondMySet)\n" + Arrays.toString(firstMySet.toArray()) + "\n");
        System.out.println("-------------------------------");
        firstMySet.removeAll(secondMySet);
        System.out.print("firstMySet.removeAll(secondMySet)\n" + Arrays.toString(firstMySet.toArray()) + "\n");
        System.out.println("-------------------------------");

        System.out.println("Чи містить початкова колекція всі елементи меншої колекції: " + gameRoomSet.containsAll(secondMySet));
        System.out.println("-------------------------------");

        GameRoom[] A = new GameRoom[7];
        A[0] = obj7;
        A[1] = obj6;
        A[2] = obj5;
        A[3] = obj4;
        A[4] = obj3;
        A[5] = obj2;
        A[6] = obj1;

        System.out.println(Arrays.toString(A) + "\n");

        System.out.println("-------------------------------");

        secondMySet.remove(obj1);
        secondMySet.remove(obj2);
        System.out.println("remove\n" + Arrays.toString(secondMySet.toArray()) + "\n");
        System.out.println("-------------------------------");
        secondMySet.addAll(firstMySet);
        System.out.println("addAll\n" + Arrays.toString(secondMySet.toArray()) + "\n");
        System.out.println("-------------------------------");
        secondMySet.clear();
        System.out.println(Arrays.toString(secondMySet.toArray()));
        System.out.println("-------------------------------");

        Iterator<GameRoom> trainIterator = gameRoomSet.iterator();
        System.out.println("trainIterator.hasNext(): " + trainIterator.hasNext());
        System.out.println("-------------------------------");
        System.out.println("trainIterator.next()" + trainIterator.next());
    }
}