package br.com.fiap.agroclimate.dto.fazendaDto;

import jakarta.validation.constraints.*;

public record CadastrarFazendaDto(
        @NotNull
        @Size(max = 14, min = 14)
        String cnpj,

        @NotBlank
        @Size(max = 100, min = 10)
        String nome,


        @Size(max = 8, min = 8)
        @NotNull
        String cep,

        @NotNull
        @NotBlank
        @Email
        String email,

        @NotNull
        String telefone,

        @NotNull@Min(100)
        Integer tamanhoFazenda) {
}
