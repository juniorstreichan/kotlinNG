package br.com.juniorstreichan.apivendas.resource

import br.com.juniorstreichan.apivendas.domain.Cliente
import br.com.juniorstreichan.apivendas.service.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("clientes")
class ClienteResource {

    @Autowired
    private lateinit var service: ClienteService

    @GetMapping
    fun listar(): ResponseEntity<Collection<Cliente>> {
        val lista = service.listClientes()
        return ResponseEntity.ok().body(lista)
    }

}