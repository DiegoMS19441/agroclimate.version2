package br.com.fiap.agroclimate.dto.climaDto;

import jakarta.validation.constraints.*;

import java.util.Calendar;

public record CadastrarClimaDto(
        @NotNull@Min(7)@Max(39)
        Integer temperatura,

        @NotNull@NotBlank@Size(min=4, max=10)
        String umidade,

        @NotNull@NotBlank@Size(min = 5)
        String precipitacao,

        @NotNull@Past
        Calendar data) {
}
