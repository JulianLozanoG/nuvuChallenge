package lozano.nuvuback.exceptions;

import org.springframework.http.HttpStatus;

public final class ClientServiceErrorException extends APIErrorException{

    public static final ClientServiceErrorException CLIENT_NOT_FOUND_EXCEPTION;
    public static final ClientServiceErrorException CLIENTS_NOT_FOUND_EXCEPTION;

    static {
        CLIENT_NOT_FOUND_EXCEPTION = new ClientServiceErrorException(HttpStatus.NOT_FOUND, "Client does not exists.");
        CLIENTS_NOT_FOUND_EXCEPTION = new ClientServiceErrorException(HttpStatus.NOT_FOUND, "Clients not found");
    }

    private ClientServiceErrorException (HttpStatus status, String message){
        super(status, message);
    }
}
