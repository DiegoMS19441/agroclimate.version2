package br.com.fiap.agroclimate.dto.safraDto;

import java.util.Calendar;

public record AtualizarSafraDto(Calendar dataInicio,
                                Calendar dataTermino) {
}
