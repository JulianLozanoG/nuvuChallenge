import { Component, OnInit } from '@angular/core';
import {ClientsService} from "./services/clients.service";

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styles: [
  ]
})
export class ClientsComponent implements OnInit {

  public clients: any = [];
  public creditCards: any = [];

  constructor( private clientsService: ClientsService) { }

  ngOnInit(): void {
    this.clientsService.getClientsList()
      .subscribe( resp => {
          this.clients = resp.clients;

      });
  }

}
