package com.infp.ciat.common.exceptions;

/***
 * 게시판생성실패
 */
public class FailCreateBoard extends Exception{
    public FailCreateBoard() {
    }

    public FailCreateBoard(String message) {
        super(message);
    }

    public FailCreateBoard(String message, Throwable cause) {
        super(message, cause);
    }

    public FailCreateBoard(Throwable cause) {
        super(cause);
    }

    public FailCreateBoard(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
