package br.com.fiap.agroclimate.dto.soloDto;

import br.com.fiap.agroclimate.model.Solo;

public record ListagemSoloDto(String tipoSolo, Integer phSolo, String nutrientesSolo) {

    public ListagemSoloDto(Solo Solo) {
        this(Solo.getTipoSolo(), Solo.getPhSolo(),Solo.getNutrientesSolo());

    }
}
