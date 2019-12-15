package com.company;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MySetTest {

    static private MySet gameRoomSet;

    static private GameRoom obj1;
    static private GameRoom obj2;
    static private GameRoom obj3;


    @BeforeAll
    static void setup() {
        obj1 = new Big("Car", 12, 250);
        obj2 = new Middle("Doll", 4, 230);
        obj3 = new Small("Mobile phone", 10, 400);

        gameRoomSet = new MySet();

        gameRoomSet.add(obj1);
        gameRoomSet.add(obj2);
        gameRoomSet.add(obj3);
    }


    @Test
    void containsGameRoomObj() {
        Assertions.assertEquals(gameRoomSet.get(0), obj1);
        Assertions.assertEquals(gameRoomSet.get(1), obj2);
        Assertions.assertEquals(gameRoomSet.get(2), obj3);
        Assertions.assertEquals(gameRoomSet.contains(obj1), true);
        Assertions.assertEquals(gameRoomSet.contains(obj2), true);
        Assertions.assertEquals(gameRoomSet.contains(obj3), true);
    }

    @Test
    void sizeMySet() {
        Assertions.assertEquals(gameRoomSet.size(), 3);
    }

    @Test
    void isEmptyMySet() {
        MySet gameRoomSet = new MySet();

        Assertions.assertEquals(gameRoomSet.size(), 0);
    }

    @Test
    void addObjToMySet() {
        GameRoom obj1 = new GameRoom("Spiner", 9, 125);
        GameRoom obj2 = new GameRoom("Tiger", 7, 90);

        MySet gameRoomSet = new MySet();

        Assertions.assertEquals(gameRoomSet.add(obj1), true);
        Assertions.assertEquals(gameRoomSet.add(obj2), true);
    }

    @Test
    void removObjFromMySet() {
        GameRoom obj1 = new GameRoom("Spiner", 9, 125);
        GameRoom obj2 = new GameRoom("Tiger", 7, 90);
        GameRoom obj3 = new GameRoom("Car", 12, 250);
        GameRoom obj4 = new GameRoom("Doll", 4, 230);

        MySet gameRoomSet = new MySet();

        gameRoomSet.add(obj1);
        gameRoomSet.add(obj2);
        gameRoomSet.add(obj3);
        gameRoomSet.add(obj4);

        gameRoomSet.remove(obj4);

        Assertions.assertEquals(gameRoomSet.size(), 3);
        Assertions.assertEquals(gameRoomSet.remove(4), false);
    }

    @Test
    void containAllObjMySet() {
        GameRoom obj1 = new GameRoom("Spiner", 9, 125);
        GameRoom obj2 = new GameRoom("Tiger", 7, 90);

        MySet gameRoomSet1 = new MySet();
        MySet gameRoomSet2 = new MySet();

        gameRoomSet1.add(obj1);
        gameRoomSet1.add(obj2);

        gameRoomSet2.add(obj1);

        Assertions.assertEquals(gameRoomSet1.get(0), gameRoomSet2.get(0));
        Assertions.assertEquals(gameRoomSet1.containsAll(gameRoomSet2), true);
    }

    @Test
    void addAllObj() {
        GameRoom obj1 = new GameRoom("Spiner", 9, 125);
        GameRoom obj2 = new GameRoom("Tiger", 7, 90);

        MySet gameRoomSet1 = new MySet();
        MySet gameRoomSet2 = new MySet();

        gameRoomSet1.add(obj1);
        gameRoomSet1.add(obj2);

        gameRoomSet2.addAll(gameRoomSet1);

        Assertions.assertEquals(gameRoomSet1.size(), gameRoomSet2.size());
        Assertions.assertEquals(gameRoomSet2.addAll(gameRoomSet1), true);
        Assertions.assertEquals(gameRoomSet2.contains(obj1), true);
        Assertions.assertEquals(gameRoomSet2.contains(obj2), true);
    }

    @Test
    void clearObj() {
        GameRoom obj1 = new GameRoom("Spiner", 9, 125);
        GameRoom obj2 = new GameRoom("Tiger", 7, 90);

        MySet gameRoomSet = new MySet();

        gameRoomSet.add(obj1);
        gameRoomSet.add(obj2);

        gameRoomSet.clear();

        Assertions.assertEquals(gameRoomSet.get(0), null);
        Assertions.assertEquals(gameRoomSet.get(1), null);
        Assertions.assertEquals(gameRoomSet.size(), 0);

    }

    @Test
    void retainAllObj() {
        GameRoom obj1 = new GameRoom("Spiner", 9, 125);
        GameRoom obj2 = new GameRoom("Tiger", 7, 90);
        GameRoom obj3 = new GameRoom("Car", 12, 250);
        GameRoom obj4 = new GameRoom("Doll", 4, 230);

        MySet gameRoomSet1 = new MySet();
        MySet gameRoomSet2 = new MySet();

        gameRoomSet1.add(obj1);
        gameRoomSet1.add(obj2);
        gameRoomSet1.add(obj3);
        gameRoomSet1.add(obj4);

        gameRoomSet2.add(obj1);
        gameRoomSet2.add(obj2);
        gameRoomSet1.retainAll(gameRoomSet2);
        Assertions.assertEquals(gameRoomSet1.get(0), obj1);
        Assertions.assertEquals(gameRoomSet1.get(1), obj2);
        Assertions.assertEquals(gameRoomSet1.size(), 2);

    }

    @Test
    void removeAllObj() {
        GameRoom obj1 = new GameRoom("Spiner", 9, 125);
        GameRoom obj2 = new GameRoom("Tiger", 7, 90);
        GameRoom obj3 = new GameRoom("Car", 12, 250);
        GameRoom obj4 = new GameRoom("Doll", 4, 230);

        MySet gameRoomSet1 = new MySet();
        MySet gameRoomSet2 = new MySet();

        gameRoomSet1.add(obj1);
        gameRoomSet1.add(obj2);
        gameRoomSet1.add(obj3);
        gameRoomSet1.add(obj4);

        gameRoomSet2.add(obj1);
        gameRoomSet2.add(obj3);
        gameRoomSet1.removeAll(gameRoomSet2);
        Assertions.assertEquals(gameRoomSet1.get(0), obj2);
        Assertions.assertEquals(gameRoomSet1.get(1), obj4);
        Assertions.assertEquals(gameRoomSet1.size(), 2);

    }

}
