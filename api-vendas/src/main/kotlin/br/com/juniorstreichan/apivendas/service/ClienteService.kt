package br.com.juniorstreichan.apivendas.service

import br.com.juniorstreichan.apivendas.domain.Cliente
import br.com.juniorstreichan.apivendas.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ClienteService {

    @Autowired
    private lateinit var repo: ClienteRepository

    fun listClientes(): Collection<Cliente> {
        return repo.findAll().toSet()
    }
}