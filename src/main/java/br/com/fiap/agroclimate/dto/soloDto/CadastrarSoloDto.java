package br.com.fiap.agroclimate.dto.soloDto;

import jakarta.validation.constraints.*;

public record CadastrarSoloDto(
        @NotNull@NotBlank
        String tipoSolo,
        @NotNull@Min(1)@Max(14)
        Integer phSolo,
        @NotNull@NotBlank
        String nutrientesSolo) {
}
