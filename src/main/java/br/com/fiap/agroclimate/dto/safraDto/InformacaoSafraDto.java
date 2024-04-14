package br.com.fiap.agroclimate.dto.safraDto;

import br.com.fiap.agroclimate.model.Safra;

import java.util.Calendar;

public record InformacaoSafraDto(Calendar dataInicio,
                                  Calendar dataTermino) {

    public InformacaoSafraDto(Safra safra){
        this(safra.getDataInicio(),safra.getDataTermino());
    }
}
