package lozano.nuvuback.controllers.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lozano.nuvuback.entities.CreditCard;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreditCardsResponse {
    @JsonProperty("credit_cards")
    private final List<CreditCard> creditCards;
}
