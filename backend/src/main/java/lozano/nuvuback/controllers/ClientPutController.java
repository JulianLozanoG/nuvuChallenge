package lozano.nuvuback.controllers;

import io.swagger.annotations.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lozano.nuvuback.controllers.domain.ClientResponse;
import lozano.nuvuback.entities.Client;
import lozano.nuvuback.exceptions.ApiError;
import lozano.nuvuback.exceptions.ClientServiceErrorException;
import lozano.nuvuback.services.ClientService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

import static java.util.Objects.isNull;

@Api(tags = {"Clients"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientPutController {

    private final ClientService clientService;

    @ApiOperation(value = "Updates a single Client, identified by Client ID", response = ClientResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok, Client updated successfully", response = ClientResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying", response = ApiError.class),
            @ApiResponse(code = 404, message = "ClientId was not found", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse> UpdateClient(

            @RequestBody
            @Valid Client clientUpdateRequest) {

        Client client = clientService.getClient(clientUpdateRequest.getId());
        if (isNull(client))
            throw ClientServiceErrorException.CLIENT_NOT_FOUND_EXCEPTION;

        clientService.updateClient(clientUpdateRequest);

        return ok(new ClientResponse(clientUpdateRequest));
    }
}
