package br.com.fiap.agroclimate.dto.climaDto;

import br.com.fiap.agroclimate.model.Clima;
import java.util.Calendar;

public record DetalheClimaDto(Long id,Integer temperatura,
                              String umidade, String precipitacao, Calendar data) {


    public DetalheClimaDto(Clima clima){
        this(clima.getId(), clima.getTemperatura(), clima.getUmidade(),
                clima.getPrecipitacao(), clima.getData());
    }
}
