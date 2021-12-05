package com.infp.ciat.common.exceptions;

/***
 * 게시판생성실패
 */
public class FailCreateFeed extends Exception{
    public FailCreateFeed() {
    }

    public FailCreateFeed(String message) {
        super(message);
    }

    public FailCreateFeed(String message, Throwable cause) {
        super(message, cause);
    }

    public FailCreateFeed(Throwable cause) {
        super(cause);
    }

    public FailCreateFeed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
