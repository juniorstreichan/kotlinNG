import { API_CONFIG } from "./../config/api.config";
import { Venda, VendaInsertDTO } from "./../models/venda";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class VendasService {
  constructor(private http: HttpClient) {}

  listar(): Observable<Venda[]> {
    return this.http.get<Venda[]>(`${API_CONFIG.baseUrl}/vendas`);
  }

  adicioar(venda: VendaInsertDTO): Observable<Venda> {
    console.log(venda);
    
    return this.http.post<Venda>(`${API_CONFIG.baseUrl}/vendas`,venda);
  }
}
