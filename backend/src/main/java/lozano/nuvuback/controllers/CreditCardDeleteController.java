package lozano.nuvuback.controllers;

import io.swagger.annotations.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lozano.nuvuback.controllers.domain.CreditCardsResponse;
import lozano.nuvuback.entities.CreditCard;
import lozano.nuvuback.exceptions.ApiError;
import lozano.nuvuback.exceptions.CreditCardServiceErrorException;
import lozano.nuvuback.services.CreditCardService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Credit Cards"})
@RestController
@AllArgsConstructor
@RequestMapping("/credit-cards")
public class CreditCardDeleteController {
    private final CreditCardService creditCardService;

    @ApiOperation(value = "Ok, Client deleted successfully", response = CreditCardsResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = CreditCardsResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    @DeleteMapping(value = "/{creditCardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCreditCard(
            @ApiParam(value = "Credit Card ID", required = true)
            @NotBlank
            @PathVariable Integer creditCardId) {

        List<CreditCard> creditCard = creditCardService.getCreditCards(creditCardId);
        if (creditCard.isEmpty())
            throw CreditCardServiceErrorException.CREDIT_CARD_NOT_FOUND_EXCEPTION;

        creditCardService.deleteCreditCard(creditCardId);
    }
}
