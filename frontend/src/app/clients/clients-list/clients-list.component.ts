import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ClientsService} from "../services/clients.service";
import {Router} from "@angular/router";
import {Client} from "../models/client";

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styles: [
  ]
})
export class ClientsListComponent implements OnInit {
  clients: Observable<Client[]>;

  constructor(private clientService: ClientsService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.clients = this.clientService.getClientsList();
  }

}
