package br.com.fiap.agroclimate.controller;

import br.com.fiap.agroclimate.dto.agricultorDto.ListagemAgricultorDto;
import br.com.fiap.agroclimate.dto.safraDto.AtualizarSafraDto;
import br.com.fiap.agroclimate.dto.safraDto.CadastrarSafraDto;
import br.com.fiap.agroclimate.dto.safraDto.InformacaoSafraDto;
import br.com.fiap.agroclimate.dto.safraDto.ListagemSafraDto;
import br.com.fiap.agroclimate.model.Safra;
import br.com.fiap.agroclimate.repository.SafraRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("safras")
public class SafraController {

    @Autowired
    private SafraRepository safraRepository;


    //Fazendo a injeção dos dados no BD
    @PostMapping
    @Transactional
    public ResponseEntity<InformacaoSafraDto> post(@RequestBody @Valid CadastrarSafraDto safraDto, UriComponentsBuilder uriBuilder) {
        var safra = new Safra(safraDto);
        safraRepository.save(safra);
        var uri = uriBuilder.path("/safras/{id}").buildAndExpand(safra.getId()).toUri();
        return ResponseEntity.created(uri).body(new InformacaoSafraDto(safra));
    }
    @DeleteMapping("{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        safraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<InformacaoSafraDto> put(@PathVariable("id")Long id,
                                                       @RequestBody AtualizarSafraDto dto){
        var safra = safraRepository.getReferenceById(id);
        safra.atualizarSafra(dto);
        return ResponseEntity.ok(new InformacaoSafraDto(safra));
    }
    @GetMapping("{id}")
    public ResponseEntity<InformacaoSafraDto> get(@PathVariable("id")Long id){
        var safra = safraRepository.getReferenceById(id);
        return ResponseEntity.ok(new InformacaoSafraDto(safra));
    }
    @GetMapping
    public ResponseEntity<List<ListagemSafraDto>> get(Pageable pageable) {
        var listaDto = safraRepository.findAll(pageable)
                .stream().map(ListagemSafraDto::new).toList();
        return ResponseEntity.ok(listaDto);

    }
}
