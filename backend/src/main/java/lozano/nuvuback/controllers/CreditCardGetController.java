package lozano.nuvuback.controllers;

import io.swagger.annotations.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lozano.nuvuback.controllers.domain.CreditCardsResponse;
import lozano.nuvuback.entities.CreditCard;
import lozano.nuvuback.exceptions.ApiError;
import lozano.nuvuback.exceptions.CreditCardServiceErrorException;
import lozano.nuvuback.services.CreditCardService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Api(tags = {"Credit Cards"})
@CrossOrigin(origins = {"http://localhost:4200"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/credit-cards")
public class CreditCardGetController {

    private final CreditCardService creditCardService;

    @ApiOperation(value = "Returns a list of credit cards, the list will be obtained by the Client ID", response = CreditCardsResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieve a Client", response = CreditCardsResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying", response = ApiError.class),
            @ApiResponse(code = 404, message = "ClientId was not found", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    @GetMapping(value = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCardsResponse> getCreditCards(
            @ApiParam(value = "ID for the Client.", required = true)
            @Pattern(regexp = "^[0-9]{4}", message = "The Client ID should contain only numeric characters and its length si not mayor than 4.")
            @PathVariable Integer clientId){

        List<CreditCard> creditCard = creditCardService.getCreditCards(clientId);
        if (creditCard.isEmpty()) {
            throw CreditCardServiceErrorException.CREDIT_CARD_NOT_FOUND_EXCEPTION;
        }
        return ok(new CreditCardsResponse(creditCard));
    }
}
