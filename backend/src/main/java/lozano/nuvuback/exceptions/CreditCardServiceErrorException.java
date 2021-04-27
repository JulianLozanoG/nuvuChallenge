package lozano.nuvuback.exceptions;

import org.springframework.http.HttpStatus;

public final class CreditCardServiceErrorException extends APIErrorException{

    public static final CreditCardServiceErrorException CREDIT_CARD_NOT_FOUND_EXCEPTION;
    public static final CreditCardServiceErrorException CREDIT_CARDS_NOT_FOUND_EXCEPTION;

    static {
        CREDIT_CARD_NOT_FOUND_EXCEPTION = new CreditCardServiceErrorException(HttpStatus.NOT_FOUND, "Credit cards not exists.");
        CREDIT_CARDS_NOT_FOUND_EXCEPTION = new CreditCardServiceErrorException(HttpStatus.NOT_FOUND, "Credit cards not found");
    }

    private CreditCardServiceErrorException (HttpStatus status, String message){
        super(status, message);
    }
}
