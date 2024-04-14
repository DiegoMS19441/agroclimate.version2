package br.com.fiap.agroclimate.dto.soloDto;

import br.com.fiap.agroclimate.model.Solo;

public record DetalheSoloDto(String tipoSolo, Integer phSolo, String nutrientesSolo) {

    public DetalheSoloDto(Solo Solo) {
        this(Solo.getTipoSolo(), Solo.getPhSolo(), Solo.getNutrientesSolo());

    }
}
