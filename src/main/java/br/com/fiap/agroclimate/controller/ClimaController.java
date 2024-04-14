package br.com.fiap.agroclimate.controller;


import br.com.fiap.agroclimate.dto.climaDto.AtualizarClimaDto;
import br.com.fiap.agroclimate.dto.climaDto.CadastrarClimaDto;
import br.com.fiap.agroclimate.dto.climaDto.DetalheClimaDto;
import br.com.fiap.agroclimate.dto.climaDto.ListagemClimaDto;
import br.com.fiap.agroclimate.model.Clima;
import br.com.fiap.agroclimate.repository.ClimaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("climas")
public class ClimaController {

    @Autowired

    private ClimaRepository climaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalheClimaDto> post(@RequestBody @Valid CadastrarClimaDto climaDto, UriComponentsBuilder uriBuilder) {
        var clima = new Clima(climaDto);
        climaRepository.save(clima);
        var uri = uriBuilder.path("/climas/{id}").buildAndExpand(clima.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalheClimaDto(clima));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        climaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalheClimaDto> put(@PathVariable("id") Long id,
                                                       @RequestBody AtualizarClimaDto dto) {
        var clima = climaRepository.getReferenceById(id);
        clima.atualizarClima(dto);
        return ResponseEntity.ok(new DetalheClimaDto(clima));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalheClimaDto> get(@PathVariable("id") Long id) {
        var clima = climaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalheClimaDto(clima));
    }

    @GetMapping
    public ResponseEntity<List<ListagemClimaDto>> get(Pageable pageable) {
        var listaDto = climaRepository.findAll(pageable)
                .stream().map(ListagemClimaDto::new).toList();
        return ResponseEntity.ok(listaDto);

    }
}
