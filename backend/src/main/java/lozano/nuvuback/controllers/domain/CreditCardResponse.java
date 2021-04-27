package lozano.nuvuback.controllers.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lozano.nuvuback.entities.CreditCard;

@Getter
@AllArgsConstructor
public class CreditCardResponse {

    @JsonProperty("credit_card")
    private final CreditCard creditCards;
}
