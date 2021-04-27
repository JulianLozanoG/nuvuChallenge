package lozano.nuvuback.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lozano.nuvuback.controllers.domain.CreditCardResponse;
import lozano.nuvuback.controllers.domain.CreditCardsResponse;
import lozano.nuvuback.entities.CreditCard;
import lozano.nuvuback.exceptions.ApiError;
import lozano.nuvuback.services.CreditCardService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@Api(tags = {"Credit Cards"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/credit-cards")
public class CreditCardPostController {

    private final CreditCardService creditCardService;

    @ApiOperation(value = "Creates a single Credit Card", response = CreditCardsResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = CreditCardsResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCreditCard(
            @RequestBody
            @Valid CreditCard creditCardCreateRequest) {

        creditCardService.createCreditCard(creditCardCreateRequest);
    }
}
