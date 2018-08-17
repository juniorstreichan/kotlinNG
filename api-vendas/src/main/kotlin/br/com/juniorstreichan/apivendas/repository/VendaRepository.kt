package br.com.juniorstreichan.apivendas.repository
import br.com.juniorstreichan.apivendas.domain.Venda
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
interface VendaRepository : JpaRepository<Venda, Int> {}