import { Item, ItemDTO } from "./item";
import { Cliente } from "./cliente";

export class Venda {
  id: string = '';
  cliente: Cliente = new Cliente();
  cadastro: string = '';
  frete: number = 0;
  itens: Item[] = [];
  total: number = 0;

  public toInsertDTO(): VendaInsertDTO {
    let itensDTO:ItemDTO[]  = [];
     this.itens.forEach(i => {
       itensDTO.push(new ItemDTO(i));
     });
    return {
      clienteId:this.cliente.id,
      frete:this.frete,
      itens:itensDTO
    };
  }
}

export class VendaInsertDTO {
  clienteId: string;
  frete: number;
  itens: ItemDTO[];

  // constructor(venda: Venda) {
  //   this.cliente = venda.cliente.id;
  //   this.frete = venda.frete;
  //   venda.itens.forEach(i => 
  //     this.itens.push(new ItemDTO(i))
  //   );
  // }
}
