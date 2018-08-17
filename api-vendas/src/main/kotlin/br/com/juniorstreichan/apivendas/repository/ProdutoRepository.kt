package br.com.juniorstreichan.apivendas.repository

import br.com.juniorstreichan.apivendas.domain.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProdutoRepository : JpaRepository<Produto,Int>{}