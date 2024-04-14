package br.com.fiap.agroclimate.controller;

import br.com.fiap.agroclimate.dto.plantacaoDto.AtualizarInfoPlantacaoDto;
import br.com.fiap.agroclimate.dto.plantacaoDto.CadastrarInfoPlantacaoDto;
import br.com.fiap.agroclimate.dto.plantacaoDto.DetalhePlantacaoDto;
import br.com.fiap.agroclimate.model.InfoPlantacao;
import br.com.fiap.agroclimate.repository.InfoPlantacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("infoplantacoes")
public class PlantacaoController {

    @Autowired
    private InfoPlantacaoRepository InfoPlantacaoRepository;


    //Fazendo a injeção dos dados no BD
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhePlantacaoDto> post(@RequestBody CadastrarInfoPlantacaoDto PlantacaoDto, UriComponentsBuilder uriBuilder) {
        var InfoPlantacao = new InfoPlantacao(PlantacaoDto);
        InfoPlantacaoRepository.save(InfoPlantacao);
        var uri = uriBuilder.path("/infoplantacaoes/{id}").buildAndExpand(InfoPlantacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhePlantacaoDto(InfoPlantacao));
    }
    @DeleteMapping("{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        InfoPlantacaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhePlantacaoDto> put(@PathVariable("id")Long id,
                                                  @RequestBody AtualizarInfoPlantacaoDto dto){
        var InfoPlantacao = InfoPlantacaoRepository.getReferenceById(id);
        InfoPlantacao.atualizarInfoPlantacao(dto);
        return ResponseEntity.ok(new DetalhePlantacaoDto(InfoPlantacao));
    }
    @GetMapping("{id}")
    public ResponseEntity<DetalhePlantacaoDto> get(@PathVariable("id")Long id){
        var InfoPlantacao = InfoPlantacaoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhePlantacaoDto(InfoPlantacao));
    }
}
