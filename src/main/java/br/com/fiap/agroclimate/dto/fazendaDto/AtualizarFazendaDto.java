package br.com.fiap.agroclimate.dto.fazendaDto;

public record AtualizarFazendaDto(Long id, String cnpj, String nome,
                                  String cep, String email, String telefone, Integer tamanhoFazenda) {
}
