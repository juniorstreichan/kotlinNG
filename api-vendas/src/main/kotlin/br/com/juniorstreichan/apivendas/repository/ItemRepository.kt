package br.com.juniorstreichan.apivendas.repository

import br.com.juniorstreichan.apivendas.domain.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ItemRepository : JpaRepository<Item, Int> {}