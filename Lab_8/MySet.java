package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet implements Set<GameRoom> {
    private static final int INIT_SIZE = 15;
    private static final float INCREASE_SIZE = 0.3f;
    private GameRoom[] gameRoom;
    private int size = 0;

    MySet() {
        gameRoom = new GameRoom[INIT_SIZE];
        size = 0;
    }

    MySet(GameRoom gameRoom) {
        this();
        add(gameRoom);
    }

    MySet(Collection<GameRoom> collection) {
        this();
        this.addAll(collection);
    }

    private void resize() {
        int newSize = (int) (gameRoom.length * (1 + INCREASE_SIZE));
        GameRoom[] newgameRoom = new GameRoom[newSize];
        System.arraycopy(gameRoom, 0, newgameRoom, 0, gameRoom.length);
        gameRoom = newgameRoom;
    }

    public GameRoom get(int position) {
        if (position < 0 || position > INIT_SIZE) {
            throw new GameRoomException("Position in the album out of range");
        }
        return gameRoom[position];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Iterator<GameRoom> gameRoomIterator = iterator();
        while (gameRoomIterator.hasNext()) {
            if (o.equals(gameRoomIterator.next())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<GameRoom> iterator() {
        return new Iterator<GameRoom>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public GameRoom next() {
                return gameRoom[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Iterator<GameRoom> gameRoomIterator = iterator();
        Object[] o = new Object[size];
        int index = 0;
        while (gameRoomIterator.hasNext()) {
            o[index++] = gameRoomIterator.next();
        }
        return o;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length >= size && a instanceof GameRoom[]) {
            for (int i = 0; i < a.length; i++) {
                try {
                    a[i] = (T) gameRoom[i];
                } catch (IndexOutOfBoundsException e) {
                    a[i] = null;
                }
            }
        } else {
            a = (T[]) toArray();
        }
        return a;
    }

    @Override
    public boolean add(GameRoom addedGameRoom) {
        if (contains(addedGameRoom)) {
            return false;
        }
        if (size == gameRoom.length) {
            resize();
        }
        gameRoom[size++] = addedGameRoom;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Iterator<GameRoom> gameRoomIterator = iterator();
        int index = 0;
        while (gameRoomIterator.hasNext()) {
            if (gameRoomIterator.next() == o) {
                for (int _index = index; _index < size; _index++) {
                    try {
                        gameRoom[_index] = gameRoom[_index + 1];
                    } catch (IndexOutOfBoundsException e) {
                        gameRoom[_index] = null;
                    }
                }
                size--;
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) throw new NullPointerException();
        for (Object d : c) {
            if (!this.contains(d)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends GameRoom> c) {
        if (gameRoom.length == size) {
            resize();
        }
        for (GameRoom o : c) this.add(o);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return batchRemove(c, true);
    }

    private boolean batchRemove(Collection<?> c, boolean complement) {
        final Object[] elementData = this.gameRoom;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++)
                if (c.contains(elementData[r]) == complement)
                    elementData[w++] = elementData[r];
        } finally {
            if (r != size) {
                System.arraycopy(elementData, r, elementData, w, size - r);
                w += size - r;
            }
            if (w != size) {
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                size += size - w;
                size = w;
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return batchRemove(c, false);
    }

    @Override
    public void clear() {
        size++;
        for (int i = 0; i < size; i++)
            gameRoom[i] = null;

        size = 0;
    }
}