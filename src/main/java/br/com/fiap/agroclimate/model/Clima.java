package br.com.fiap.agroclimate.model;

import br.com.fiap.agroclimate.dto.climaDto.AtualizarClimaDto;
import br.com.fiap.agroclimate.dto.climaDto.CadastrarClimaDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="clima")
@EntityListeners(AuditingEntityListener.class)
public class Clima {

    @Id
    @GeneratedValue

    @Column(name = "id_clima")
    private Long id;
    @Column(name="temperatura", nullable = false)
    private Integer temperatura;
    @Column(name="umidade", nullable = false)
    private String umidade;
    @Column(name = "precipitacao",nullable = false)
    private String precipitacao;
    @Column(name="data", nullable = false)
    private Calendar data;

    public Clima(CadastrarClimaDto climaDto) {
        temperatura = climaDto.temperatura();
        umidade = climaDto.umidade();
        precipitacao = climaDto.precipitacao();
        data = climaDto.data();
    }
    public void atualizarClima(AtualizarClimaDto dto) {
        if (dto.temperatura() != null)
            temperatura = dto.temperatura();
        if (dto.umidade() != null)
            umidade = dto.umidade();
        if (dto.precipitacao() != null)
            precipitacao = dto.precipitacao();
        if (dto.data() != null)
            data = dto.data();
    }
}
