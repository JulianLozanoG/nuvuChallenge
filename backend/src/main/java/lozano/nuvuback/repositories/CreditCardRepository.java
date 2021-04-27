package lozano.nuvuback.repositories;

import lozano.nuvuback.entities.Client;
import lozano.nuvuback.entities.CreditCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {
    List<CreditCard> findAllByClientId(Integer clientId);
}
