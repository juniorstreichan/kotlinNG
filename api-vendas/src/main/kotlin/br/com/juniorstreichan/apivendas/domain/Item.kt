package br.com.juniorstreichan.apivendas.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
data class Item(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0,


        @JsonIgnore
        @ManyToOne
        val venda: Venda = Venda(),

        @NotNull
        @ManyToOne
        val produto: Produto = Produto(),

        private val descricao: String = produto.descricao,

        @NotNull
        val quantidade: Int = 0

){
        fun getDescricao():String = descricao
}