package lozano.nuvuback.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class APIErrorException extends RuntimeException{

    private final HttpStatus status;
    private final Throwable cause;
    private final Integer errorCode;

    public APIErrorException(HttpStatus status, String message) {
        this(status, message, null, null);
    }

    public APIErrorException(HttpStatus status, String message, Throwable cause, Integer errorCode) {
        super(message);
        this.status = status;
        this.cause = cause;
        this.errorCode = errorCode;
    }
}
