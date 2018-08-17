package br.com.juniorstreichan.apivendas.service

import br.com.juniorstreichan.apivendas.domain.Cliente
import br.com.juniorstreichan.apivendas.domain.Item
import br.com.juniorstreichan.apivendas.domain.Venda
import br.com.juniorstreichan.apivendas.dto.VendaInsertDTO
import br.com.juniorstreichan.apivendas.repository.ItemRepository
import br.com.juniorstreichan.apivendas.repository.VendaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class VendaService {

    @Autowired
    private lateinit var repo: VendaRepository

    @Autowired
    private lateinit var itemRepo: ItemRepository

    @Autowired
    private lateinit var produtoService: ProdutoService

    @Transactional
    fun adicionar(vendaDTO: VendaInsertDTO): Venda {

        val vendaTemp = Venda(
                cliente = Cliente(id = vendaDTO.clienteId),
                frete = vendaDTO.frete
        )

        vendaTemp.itens.addAll(vendaDTO.itens.map { item ->
            Item(
                    venda = vendaTemp,
                    quantidade = item.quantidade,
                    produto = produtoService.findById(item.produtoId)
            )
        })

        vendaTemp.setTotal((
                vendaTemp.itens.stream().map { item ->
                    (item.produto.valor * item.quantidade)
                }.reduce(0.00, Double::plus))
                .plus(vendaTemp.getFrete())
        )
        val newVenda = repo.save(vendaTemp)
        val newItens = itemRepo.saveAll(vendaTemp.itens)
        return newVenda.copy(itens = newItens)
    }


    fun listVendas(): Collection<Venda> {
        return repo.findAll()
    }


}