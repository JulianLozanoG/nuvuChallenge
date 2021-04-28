import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  private baseUrl = 'http://localhost:8080/client';

  constructor(private http: HttpClient) {}

  getClient(clientId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${clientId}`);
  }

  createClient(client: Object): Observable<any> {
    return this.http.post(`${this.baseUrl}`, client);
  }

  updateClient(client: Object, clientId: number): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${clientId}`, client);
  }

  deleteClient(clientId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${clientId}`, {responseType: 'text' });
  }

  getClientsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
