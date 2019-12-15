package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRoomTest {

    @Test
    void testCreatingGameRoomWithThreeParameters() {
        final GameRoom gameRoom = new GameRoom("Spiner", 9, 125);

        assertEquals("Spiner", gameRoom.getType());
        assertEquals(9, gameRoom.getOld());
        assertEquals(125, gameRoom.getPrice());

    }

    @Test
    void testCreatingInheritedClasses() {

        final GameRoom gameRoom1 = new Big("Car", 12, 250);
        final GameRoom gameRoom2 = new Middle("Tiger", 7, 90);
        final GameRoom gameRoom3 = new Small("Mobile phone", 10, 400);

        assertEquals("Car", gameRoom1.getType());
        assertEquals("Tiger", gameRoom2.getType());
        assertEquals("Mobile phone", gameRoom3.getType());


        assertEquals(12, gameRoom1.getOld());
        assertEquals(7, gameRoom2.getOld());
        assertEquals(10, gameRoom3.getOld());

        assertEquals(250, gameRoom1.getPrice());
        assertEquals(90, gameRoom2.getPrice());
        assertEquals(400, gameRoom3.getPrice());

    }

    @Test
    void CreatingGameRoomWithZeroOldShouldThrowException() {
        GameRoomException thrown =
                assertThrows(GameRoomException.class,
                        () -> new GameRoom("Spiner", 0, 125),
                        "Expected new GameRoom(\"Spiner\", 0, 125), to throw, but it didn't");

        assertTrue(thrown.getMessage().contains("Invalid parameters"));
    }

    @Test
    void CreatingGameRoomWithNegativeOldShouldThrowException() {

        GameRoomException thrown =
                assertThrows(GameRoomException.class,
                        () -> new GameRoom("Spiner", -5, 125),
                        "Expected new GameRoom(\"Spiner\", -5, 125), to throw, but it didn't");

        assertTrue(thrown.getMessage().contains("Invalid parameters"));

    }

    @Test
    void CreatingGameRoomWithNegativePriceShouldThrowException() {

        GameRoomException thrown =
                assertThrows(GameRoomException.class,
                        () -> new GameRoom("Spiner", 5, -45),
                        "Expected new GameRoom(\"Spiner\", 5, -45), to throw, but it didn't");

        assertTrue(thrown.getMessage().contains("Invalid parameters"));

    }

    @Test
    void equalsShouldReturnTrueIfObjectsAreIdentical() {
        GameRoom gameRoom1 = new GameRoom("Spiner", 9, 125);
        GameRoom gameRoom2 = new GameRoom("Spiner", 9, 125);
        assertEquals(gameRoom1, gameRoom2);

    }

    @Test
    void hashCodeOfObjectShouldReturnTheSameValueEachTime() {
        GameRoom gameRoom1 = new GameRoom("Spiner", 9, 125);
        assertEquals(gameRoom1.hashCode(), gameRoom1.hashCode());
    }


    @Test
    void hashCodeOfIdenticalObjectsShouldReturnIdenticalValues() {
        GameRoom gameRoom1 = new GameRoom("Spiner", 9, 125);
        GameRoom gameRoom2 = new GameRoom("Spiner", 9, 125);

        assertEquals(gameRoom1.hashCode(), gameRoom2.hashCode());
    }


    @Test
    void toStringShouldReturnStringOfAllValues() {
        GameRoom gameRoom1 = new GameRoom("Spiner", 9, 125);
        GameRoom gameRoom2 = new Big("Spiner", 9, 125);
        GameRoom gameRoom3 = new Middle("Spiner", 9, 125);
        GameRoom gameRoom4 = new Small("Spiner", 9, 125);

        assertEquals(gameRoom1.toString(), "\nType of toy: Spiner\nFor kids ages from: 9\nPrice: 125");
        assertEquals(gameRoom2.toString(), "\nType of toy: Spiner\nFor kids ages from: 9\nPrice: 125");
        assertEquals(gameRoom3.toString(), "\nType of toy: Spiner\nFor kids ages from: 9\nPrice: 125");
        assertEquals(gameRoom4.toString(), "\nType of toy: Spiner\nFor kids ages from: 9\nPrice: 125");


    }


}