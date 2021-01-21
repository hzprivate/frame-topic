package com.hz.exception;

/**
 * @author hz
 * @create 2021-01-21
 */
public class RedisException extends RuntimeException {
    public RedisException() {
        super();
    }

    public RedisException(String message) {
        super(message);
    }

    public RedisException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedisException(Throwable cause) {
        super(cause);
    }
}
