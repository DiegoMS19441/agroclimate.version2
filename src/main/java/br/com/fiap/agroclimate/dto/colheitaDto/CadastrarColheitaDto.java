package br.com.fiap.agroclimate.dto.colheitaDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Calendar;

public record CadastrarColheitaDto(

        @NotNull@Past
        Calendar dataColheita,

        @NotNull@NotBlank
        Integer quantidade)
 {
}
