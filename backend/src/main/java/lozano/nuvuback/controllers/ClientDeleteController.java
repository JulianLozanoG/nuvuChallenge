package lozano.nuvuback.controllers;

import io.swagger.annotations.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lozano.nuvuback.controllers.domain.ClientResponse;
import lozano.nuvuback.entities.Client;
import lozano.nuvuback.exceptions.ApiError;
import lozano.nuvuback.exceptions.ClientServiceErrorException;
import lozano.nuvuback.services.ClientService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@Api(tags = {"Clients"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientDeleteController {

    private final ClientService clientService;

    @ApiOperation(value = "Performs a cascading delete (Credit_Cards) of a single Client, identified by Client ID", response = ClientResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok, Client deleted successfully", response = ClientResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying", response = ApiError.class),
            @ApiResponse(code = 404, message = "ClientId was not found", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    @DeleteMapping(value = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteClient(
            @ApiParam(value = "Client ID", required = true)
            @NotBlank
            @PathVariable Integer clientId) {
        Client client = clientService.getClient(clientId);
        if (isNull(client))
            throw ClientServiceErrorException.CLIENT_NOT_FOUND_EXCEPTION;

        clientService.deleteClient(clientId);
    }
}
