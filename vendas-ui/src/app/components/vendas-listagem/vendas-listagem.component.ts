import { Component, OnInit } from "@angular/core";

import { VendasService } from "./../../services/vendas.service";
import { Venda } from "./../../models/venda";

@Component({
  selector: "app-vendas-listagem",
  templateUrl: "./vendas-listagem.component.html",
  styleUrls: ["./vendas-listagem.component.css"]
})
export class VendasListagemComponent implements OnInit {
  vendas: Venda[];

  constructor(private vendaService: VendasService) {}

  ngOnInit() {
   this.listar();
  }

  listar(){
    this.vendaService.listar().subscribe(
      response => {
        console.log(response);
        
        this.vendas = response as Venda[];
      },
      error => {
        console.log('erro '+error);

      }
    );
  }
}
