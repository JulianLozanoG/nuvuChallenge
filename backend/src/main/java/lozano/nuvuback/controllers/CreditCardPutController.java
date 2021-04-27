package lozano.nuvuback.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lozano.nuvuback.controllers.domain.CreditCardResponse;
import lozano.nuvuback.entities.CreditCard;
import lozano.nuvuback.exceptions.ApiError;
import lozano.nuvuback.exceptions.CreditCardServiceErrorException;
import lozano.nuvuback.services.CreditCardService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Api(tags = {"Credit Cards"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/credit-cards")
public class CreditCardPutController {

    private final CreditCardService creditCardService;

    @ApiOperation(value = "Updates a single Credit Card, identified by Credit Card ID", response = CreditCardResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok, Credit Card was updated successfully", response = CreditCardResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying", response = ApiError.class),
            @ApiResponse(code = 404, message = "CreditCardId was not found", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCardResponse> updateCreditCard(
            @RequestBody
            @Valid CreditCard creditCardUpdateRequest) {

        List<CreditCard> creditCard = creditCardService.getCreditCards(creditCardUpdateRequest.getId());
        if (creditCard.isEmpty())
            throw CreditCardServiceErrorException.CREDIT_CARD_NOT_FOUND_EXCEPTION;

        creditCardService.updateCreditCard(creditCardUpdateRequest);

        return ok(new CreditCardResponse(creditCardUpdateRequest));
    }
}
