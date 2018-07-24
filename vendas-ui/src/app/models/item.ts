import { Produto } from "./produto";
import { Venda } from "./venda";

export class Item {
  id: string = '';
  venda?: Venda;
  produto: Produto;
  quantidade: number = 0; 

  public toDTO():ItemDTO{
      return new ItemDTO(this);
  }
}

export class ItemDTO {
  produtoId: string = '';
  quantidade: number = 0;

  constructor(item: Item) {
    this.produtoId = item.produto.id;
    this.quantidade = item.quantidade;
  }
}
