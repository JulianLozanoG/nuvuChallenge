package lozano.nuvuback.controllers.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lozano.nuvuback.entities.Client;

@Getter
@AllArgsConstructor
public class ClientResponse {

    @JsonProperty("client")
    private final Client client;
}
