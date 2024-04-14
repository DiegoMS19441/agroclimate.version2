package br.com.fiap.agroclimate.dto.plantacaoDto;

import java.util.Calendar;

public record CadastrarInfoPlantacaoDto(

        Calendar dataPlantacao,

        String itemPlantado,

        Integer areaPlantada) {
}
