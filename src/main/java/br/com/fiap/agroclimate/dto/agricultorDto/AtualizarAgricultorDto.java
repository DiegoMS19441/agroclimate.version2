package br.com.fiap.agroclimate.dto.agricultorDto;


public record AtualizarAgricultorDto(String nome, String cpf, String email,
                                     String endereco, String telefone, String cep) {
}
