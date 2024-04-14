package br.com.fiap.agroclimate.dto.agricultorDto;

import br.com.fiap.agroclimate.model.Agricultor;

public record InformacaoAgricultorDto(Long id, String nome, String email, String endereco, String telefone) {

    public InformacaoAgricultorDto(Agricultor agricultor){
        this(agricultor.getId(),agricultor.getNome(),agricultor.getEmail(),agricultor.getCep(),
                agricultor.getTelefone());
    }
}
