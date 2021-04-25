package lozano.nuvuback.repositories;

import lozano.nuvuback.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    Client getClientById(Integer id);
    void deleteById(Integer id);
}
