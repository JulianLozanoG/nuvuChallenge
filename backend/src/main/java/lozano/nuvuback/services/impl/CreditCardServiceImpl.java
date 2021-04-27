package lozano.nuvuback.services.impl;

import lombok.AllArgsConstructor;
import lozano.nuvuback.entities.Client;
import lozano.nuvuback.entities.CreditCard;
import lozano.nuvuback.repositories.CreditCardRepository;
import lozano.nuvuback.services.CreditCardService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;

    @Override
    public void createCreditCard(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }

    @Override
    public List<CreditCard> getCreditCards(Integer clientId) {
        List<CreditCard> creditCards = new ArrayList<>();
        creditCardRepository.findAllByClientId(clientId).forEach(creditCards::add);
        return creditCards;
    }

    @Override
    public void deleteCreditCard(Integer creditCardId) {
        creditCardRepository.deleteById(creditCardId);
    }

    @Override
    public CreditCard updateCreditCard(CreditCard creditCard) {
        CreditCard cardUpdatable = creditCardRepository.findById(creditCard.getId()).get();
        creditCardRepository.save(cardUpdatable);
        return creditCard;
    }
}
