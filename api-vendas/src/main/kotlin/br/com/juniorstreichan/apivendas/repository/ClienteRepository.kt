package br.com.juniorstreichan.apivendas.repository

import br.com.juniorstreichan.apivendas.domain.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ClienteRepository : JpaRepository<Cliente,Int>{
}