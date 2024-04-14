package br.com.fiap.agroclimate.controller;

import br.com.fiap.agroclimate.dto.agricultorDto.AtualizarAgricultorDto;
import br.com.fiap.agroclimate.dto.agricultorDto.CadastrarAgricultorDto;
import br.com.fiap.agroclimate.dto.agricultorDto.InformacaoAgricultorDto;
import br.com.fiap.agroclimate.dto.agricultorDto.ListagemAgricultorDto;
import br.com.fiap.agroclimate.model.Agricultor;
import br.com.fiap.agroclimate.repository.AgricultorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("agricultores")
public class AgricultorController {

    @Autowired
    private AgricultorRepository agricultorRepository;



    @PostMapping
    @Transactional
    public ResponseEntity<InformacaoAgricultorDto> post(@RequestBody @Valid CadastrarAgricultorDto agricultorDto, UriComponentsBuilder uriBuilder) {
        var agricultor = new Agricultor(agricultorDto);
        agricultorRepository.save(agricultor);
        var uri = uriBuilder.path("/agricultores/{id}").buildAndExpand(agricultor.getId()).toUri();
        return ResponseEntity.created(uri).body(new InformacaoAgricultorDto(agricultor));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        agricultorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<InformacaoAgricultorDto> put(@PathVariable("id") Long id,
                                                       @RequestBody AtualizarAgricultorDto dto) {
        var agricultor = agricultorRepository.getReferenceById(id);
        agricultor.atualizarAgricultor(dto);
        return ResponseEntity.ok(new InformacaoAgricultorDto(agricultor));
    }

    @GetMapping("{id}")
    public ResponseEntity<InformacaoAgricultorDto> get(@PathVariable("id") Long id) {
        var agricultor = agricultorRepository.getReferenceById(id);
        return ResponseEntity.ok(new InformacaoAgricultorDto(agricultor));
    }

    @GetMapping
    public ResponseEntity<List<ListagemAgricultorDto>> get(Pageable pageable) {
        var listaDto = agricultorRepository.findAll(pageable)
                .stream().map(ListagemAgricultorDto::new).toList();
        return ResponseEntity.ok(listaDto);

    }
}
