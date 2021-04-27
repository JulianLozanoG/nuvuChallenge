package lozano.nuvuback.services.impl;

import lombok.AllArgsConstructor;
import lozano.nuvuback.entities.Client;
import lozano.nuvuback.repositories.ClientRepository;
import lozano.nuvuback.repositories.CreditCardRepository;
import lozano.nuvuback.services.ClientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    public Client updateClient(Client client) {
        Client clientForUpdate = clientRepository.findById(client.getId()).get();
        clientRepository.save(clientForUpdate);
        return clientForUpdate;
    }

    @Override
    public Client createClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public Client getClient(Integer clientId) {
        return clientRepository.getClientById(clientId);
    }

    @Override
    public void deleteClient(Integer clientId) {
        clientRepository.deleteById(clientId);
    }
}
