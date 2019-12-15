package com.company;

public class GameRoomException extends RuntimeException {
    public GameRoomException() {
        super();
    }

    public GameRoomException(final String message) {
        super(message);
    }

    public GameRoomException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public GameRoomException(final Throwable cause) {
        super(cause);
    }

    protected GameRoomException(final String message, final Throwable cause,
                                final boolean enableSuppression,
                                final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
