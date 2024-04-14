package br.com.fiap.agroclimate.dto.climaDto;

import java.util.Calendar;

public record AtualizarClimaDto(Long id, Integer temperatura, String umidade, String precipitacao, Calendar data) {
}
