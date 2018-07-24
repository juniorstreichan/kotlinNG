import { VendasService } from './../../services/vendas.service';
import { Item } from "./../../models/item";
import { Produto } from "./../../models/produto";
import { Component, OnInit } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { ClienteService } from "./../../services/cliente.service";
import { Cliente } from "./../../models/cliente";
import { Venda } from "../../models/venda";
import { MessageService } from 'primeng/components/common/messageservice';

@Component({
  selector: "app-venda-cadastro",
  templateUrl: "./venda-cadastro.component.html",
  styleUrls: ["./venda-cadastro.component.css"]
})
export class VendaCadastroComponent implements OnInit {
  clientes: Cliente[] = [];
  itemAdd: Item = new Item();
  venda: Venda = new Venda();
  produtos: Produto[] = [];
  constructor(
    private clienteService: ClienteService,
    private vendaService:VendasService,
    private msgService:MessageService
  ) {}

  ngOnInit() {
    // this.venda = {id:'0',cadastro:'',cliente:{id:'0',nome:''},frete:0,total:0,itens:[]}
    this.clienteService.listarClientes().subscribe(
      response => {
        this.clientes = response as Cliente[];
      },
      error => {}
    );
    this.clienteService.listarProdutos().subscribe(
      response => {
        this.produtos = response as Produto[];
      },
      error => {}
    );
  }

  addItem() {
    this.venda.itens.push(this.itemAdd);
    this.calcularTotal();
    this.itemAdd = new Item();
  }

  calcularTotal(){
    const totalItens = this.venda.itens.map(
       i =>(i.produto.valor * i.quantidade)
      ).reduce((total,v)=> total + v,0);
      this.venda.total = totalItens + this.venda.frete;
  }

  calcularTotalSemFrete(){
    const totalItens = this.venda.itens.map(
       i =>(i.produto.valor * i.quantidade)
      ).reduce((total,v)=> total + v,0);
      this.venda.total = totalItens;
  }

  remove(item: Item) {
    let index = this.venda.itens.indexOf(item);
    this.venda.itens.splice(index,1);
    this.calcularTotalSemFrete();
 
  }

  adicionarVenda(frm:FormGroup){
    console.log(this.venda);
   let venda = this.venda.toInsertDTO();
   console.log(venda);

    this.vendaService.adicioar(venda).subscribe(
      response =>{
    console.log(response);
        
        frm.reset();
        this.venda = new Venda();

        this.msgService.add({severity:'success',detail:`Venda ${response.id} registrada com sucesso!!`});
      },
      error => {
        alert(error);
      }
    );
  }

  vendaJson(): string {
    return JSON.stringify(this.venda);
  }
  clientesJson(){
    return JSON.stringify(this.clientes);
  }
  itemJson(): string {
    return JSON.stringify(this.itemAdd);
  }
}
