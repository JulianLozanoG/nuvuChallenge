package lozano.nuvuback.controllers;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Credit Cards"})
@RestController
@AllArgsConstructor
@RequestMapping("/credit-cards")
public class CreditCardPostController {
}
