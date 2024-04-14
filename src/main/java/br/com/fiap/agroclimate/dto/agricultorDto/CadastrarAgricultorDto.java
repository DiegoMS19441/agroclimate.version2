package br.com.fiap.agroclimate.dto.agricultorDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastrarAgricultorDto(
        @NotNull
        @Size(max = 70)
        @NotBlank
        String nome,

        @Size(max = 11, min = 11)
        @NotNull
        @NotBlank
        String cpf,

        @Email
        @NotNull
        @NotBlank
        String email,

        @NotNull
        String endereco,

        @NotNull
        @Size(max = 9, min = 9)
        String telefone) {
}

