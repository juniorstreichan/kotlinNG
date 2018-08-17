package br.com.juniorstreichan.apivendas.service

import br.com.juniorstreichan.apivendas.domain.Produto
import br.com.juniorstreichan.apivendas.repository.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ProdutoService {

    @Autowired
    private lateinit var repo: ProdutoRepository

    fun listProdutos(): Collection<Produto> {
        return repo.findAll()
    }

    fun findById(id: Int): Produto {
        return repo.findById(id).get()
    }


}

