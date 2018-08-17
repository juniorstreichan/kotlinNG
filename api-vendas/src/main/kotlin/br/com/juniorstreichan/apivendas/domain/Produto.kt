package br.com.juniorstreichan.apivendas.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.PositiveOrZero

@Entity
data class Produto(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0,

        @NotEmpty
        val descricao: String = "",

        @PositiveOrZero
        val valor: Double = 0.0


)