package br.com.juniorstreichan.apivendas.resource

import br.com.juniorstreichan.apivendas.domain.Venda
import br.com.juniorstreichan.apivendas.dto.VendaInsertDTO
import br.com.juniorstreichan.apivendas.service.VendaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@CrossOrigin
@RestController
@RequestMapping("vendas")
class VendaResource {


    @Autowired
    private lateinit var service: VendaService

    @GetMapping
    fun listar(): ResponseEntity<Collection<Venda>> {
        return ResponseEntity.ok().body(service.listVendas())
    }

    @PostMapping
    fun adicionar(@RequestBody @Valid venda: VendaInsertDTO): ResponseEntity<Venda> {
       println(venda);
        return ResponseEntity.ok().body(service.adicionar(venda))
    }

}