package lozano.nuvuback.services;

import lozano.nuvuback.entities.CreditCard;

import java.util.List;

public interface CreditCardService {
    void createCreditCard(CreditCard creditCard);
    List<CreditCard> getCreditCards(Integer clientId);
    void deleteCreditCard(Integer creditCardId);
    CreditCard updateCreditCard(CreditCard creditCard);
}
