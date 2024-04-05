package dev.omedia.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItemIsTakenException extends RuntimeException{
    public ItemIsTakenException() {
        super("Item is already taken out, you can not pay anymore");
    }
}
