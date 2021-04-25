package lozano.nuvuback.services;

import lozano.nuvuback.entities.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);
    Client getClient(Integer clientId);
    List<Client> getClients();
    Client updateClient(Client client);
    void deleteClient(Integer clientId);
}
