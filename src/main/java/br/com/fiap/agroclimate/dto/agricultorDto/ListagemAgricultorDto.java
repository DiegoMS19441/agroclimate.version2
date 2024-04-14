package br.com.fiap.agroclimate.dto.agricultorDto;

import br.com.fiap.agroclimate.model.Agricultor;

public record ListagemAgricultorDto(Long id, String nome, String cpf, String email,
                                    String endereco, String telefone) {

    public ListagemAgricultorDto(Agricultor agricultor){
        this(agricultor.getId(), agricultor.getNome(), agricultor.getCpf(), agricultor.getEmail(),
                agricultor.getCep(),agricultor.getTelefone());
    }
}
