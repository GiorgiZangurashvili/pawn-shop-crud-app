package dev.omedia.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItemIsConfiscatedException extends RuntimeException{

    public ItemIsConfiscatedException() {
        super("Item is confiscated. You can not pay for it anymore");
    }

}
