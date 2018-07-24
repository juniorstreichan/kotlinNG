import { Cliente } from './../models/cliente';
import { API_CONFIG } from './../config/api.config';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Produto } from '../models/produto';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http:HttpClient) { }


  listarClientes():Observable<Cliente[]>{
    return this.http.get<Cliente[]>(`${API_CONFIG.baseUrl}/clientes`);
  }


  listarProdutos():Observable<Produto[]>{
    return this.http.get<Produto[]>(`${API_CONFIG.baseUrl}/produtos`);
  }

}
