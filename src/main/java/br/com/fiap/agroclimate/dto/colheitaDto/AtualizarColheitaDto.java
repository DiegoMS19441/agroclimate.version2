package br.com.fiap.agroclimate.dto.colheitaDto;

import java.util.Calendar;

public record AtualizarColheitaDto(Calendar dataColheita, Integer quantidade) {
}
