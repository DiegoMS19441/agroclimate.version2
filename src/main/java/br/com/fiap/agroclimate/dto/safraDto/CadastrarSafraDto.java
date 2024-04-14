package br.com.fiap.agroclimate.dto.safraDto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.util.Calendar;

public record CadastrarSafraDto(

        @NotNull
        @Past
        Calendar dataInicio,


        @NotNull@Future
        Calendar dataTermino,

        @NotNull
        Integer area
) {
}
