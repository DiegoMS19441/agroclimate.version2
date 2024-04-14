package br.com.fiap.agroclimate.controller;


import br.com.fiap.agroclimate.dto.soloDto.AtualizarSoloDto;
import br.com.fiap.agroclimate.dto.soloDto.CadastrarSoloDto;
import br.com.fiap.agroclimate.dto.soloDto.DetalheSoloDto;
import br.com.fiap.agroclimate.dto.soloDto.ListagemSoloDto;
import br.com.fiap.agroclimate.model.Solo;
import br.com.fiap.agroclimate.repository.SoloRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("solos")
public class SoloController {

    @Autowired
    private SoloRepository soloRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalheSoloDto> post(@RequestBody @Valid CadastrarSoloDto soloDto,
                                               UriComponentsBuilder uriBuilder) {
        var solo = new Solo(soloDto);
        soloRepository.save(solo);
        var uri = uriBuilder.path("/solos/{id}").buildAndExpand(solo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalheSoloDto(solo));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        soloRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalheSoloDto> put(@PathVariable("id") Long id,
                                              @RequestBody AtualizarSoloDto dto) {
        var solo = soloRepository.getReferenceById(id);
        solo.atualizarSolo(dto);
        return ResponseEntity.ok(new DetalheSoloDto(solo));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalheSoloDto> get(@PathVariable("id") Long id) {
        var solo = soloRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalheSoloDto(solo));
    }

    @GetMapping
    public ResponseEntity<List<ListagemSoloDto>> get(Pageable pageable) {
        var listaDto = soloRepository.findAll(pageable)
                .stream().map(ListagemSoloDto::new).toList();
        return ResponseEntity.ok(listaDto);

    }
}
