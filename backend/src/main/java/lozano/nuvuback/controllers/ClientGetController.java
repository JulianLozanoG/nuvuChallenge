package lozano.nuvuback.controllers;

import com.sun.istack.NotNull;
import io.swagger.annotations.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lozano.nuvuback.controllers.domain.ClientResponse;
import lozano.nuvuback.controllers.domain.ClientsResponse;
import lozano.nuvuback.entities.Client;
import lozano.nuvuback.exceptions.ApiError;
import lozano.nuvuback.exceptions.ClientServiceErrorException;
import lozano.nuvuback.services.ClientService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;
import static org.springframework.http.ResponseEntity.ok;

@Api(tags = {"Clients"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientGetController {

    private final ClientService clientService;

    @ApiOperation(value = "Returns a single or a list of clients, a single client is identified by Client ID", response = ClientResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieve a Client", response = ClientResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying", response = ApiError.class),
            @ApiResponse(code = 404, message = "ClientId was not found", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    @GetMapping(value = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse> getClient(
            @ApiParam(value = "ID for the Client.", required = true)
            @Pattern(regexp = "^[0-9]{4}", message = "The Client ID should contain only numeric characters and its length si not mayor than 4.")
            @PathVariable Integer clientId){

        Client client = clientService.getClient(clientId);
        if (isNull(client)) {
            throw ClientServiceErrorException.CLIENT_NOT_FOUND_EXCEPTION;
        }
        return ok(new ClientResponse(client));
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientsResponse> getClients(){

        return ok(new ClientsResponse(clientService.getClients()));
    }
}
