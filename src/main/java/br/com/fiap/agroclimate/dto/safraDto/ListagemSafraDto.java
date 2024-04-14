package br.com.fiap.agroclimate.dto.safraDto;

import br.com.fiap.agroclimate.model.Safra;

import java.util.Calendar;

public record ListagemSafraDto(Calendar dataInicio,
                               Calendar dataTermino) {

    public ListagemSafraDto(Safra safra){
        this(safra.getDataInicio(),safra.getDataTermino());
    }
}
