package br.com.juniorstreichan.apivendas.resource

import br.com.juniorstreichan.apivendas.domain.Produto
import br.com.juniorstreichan.apivendas.service.ProdutoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("produtos")
class ProdutoResource {
    @Autowired
    private lateinit var service: ProdutoService

    @GetMapping
    fun listar(): ResponseEntity<Collection<Produto>> {
        val lista = service.listProdutos()
        return ResponseEntity.ok().body(lista)
    }
}