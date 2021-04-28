import {Client} from "./client";

export interface ClientReqRes {
  clients: Client[];
}

interface ClientOld {
  client_id:      number;
  credit_cards:   CreditCard[];
  first_name:     string;
  lastname:       string;
  identification: string;
  email:          string;
}

interface CreditCard {
  id:         number;
  clientName: string;
  cardBrand:  string;
  keyNumber:  string;
  expiration: Date;
}
