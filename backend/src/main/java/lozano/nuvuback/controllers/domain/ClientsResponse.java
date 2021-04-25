package lozano.nuvuback.controllers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lozano.nuvuback.entities.Client;

import java.util.List;

@Getter
@AllArgsConstructor
public class ClientsResponse {
    private final List<Client> clients;
}
