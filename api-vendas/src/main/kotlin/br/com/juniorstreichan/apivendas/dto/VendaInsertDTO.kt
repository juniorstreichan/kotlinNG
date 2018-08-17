package br.com.juniorstreichan.apivendas.dto

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.PositiveOrZero

data class VendaInsertDTO(

        @NotNull
        val clienteId:Int = 0,

        @PositiveOrZero
        val frete: Double = 0.0,

        @NotNull
        val itens: Collection<ItemDTO> = HashSet<ItemDTO>()

)