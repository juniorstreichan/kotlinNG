package br.com.juniorstreichan.apivendas.domain

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero


@Entity
data class Venda(

        val cadastro: LocalDateTime = LocalDateTime.now(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: Int = 0,

        @ManyToOne
        private var cliente: Cliente? = null,

        @Valid
        @NotEmpty
        @OneToMany(mappedBy = "venda")
        val itens: MutableList<Item> = mutableListOf<Item>(),

        @PositiveOrZero
        private var frete: Double = 0.0,

        @PositiveOrZero
        private var total: Double = 0.0

) {
    fun setId(id: Int) = { this.id = id }

    fun getId(): Int = id

    fun getCliente(): Cliente? = cliente

    fun setCliente(cliente: Cliente) = { this.cliente = cliente }

    fun getFrete(): Double = frete

    fun setFrete(valor: Double) { frete = valor }

    fun getTotal():Double = total

    fun setTotal(valor:Double) {total = valor}


}