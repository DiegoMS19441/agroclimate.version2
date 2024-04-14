package br.com.fiap.agroclimate.dto.fazendaDto;

import br.com.fiap.agroclimate.model.Fazenda;

public record ListagemFazendaDto(Long id, String cnpj, String nome, String cep, String email,
                                 String telefone, Integer tamanhoFazenda) {

    public ListagemFazendaDto(Fazenda fazenda){
        this(fazenda.getId(),fazenda.getCnpj(),fazenda.getNome(),
                fazenda.getCep(),fazenda.getEmail(), fazenda.getTelefone(),fazenda.getTamanhoFazenda());
    }
}
