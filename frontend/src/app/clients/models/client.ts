import {CreditCard} from "../../creditCards/models/creditCards";

export class Client{
  client_id:      number;
  credit_cards:   CreditCard[];
  first_name:     string;
  lastname:       string;
  identification: string;
  email:          string;
}
