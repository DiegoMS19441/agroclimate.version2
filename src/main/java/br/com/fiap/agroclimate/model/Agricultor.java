package br.com.fiap.agroclimate.model;

import br.com.fiap.agroclimate.dto.agricultorDto.AtualizarAgricultorDto;
import br.com.fiap.agroclimate.dto.agricultorDto.CadastrarAgricultorDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name="Agricultor")
@EntityListeners(AuditingEntityListener.class)
public class Agricultor {
    @Id
    @GeneratedValue
    @Column(name="id_agricultor")
    private Long id;

    @Column(name="nm_agricultor", nullable = false)
    private String nome;

    @Column(name="cpf")
    private String cpf;

    @Column(name="email_agricultor")
    private String email;

    @Column(name="cep",nullable = false)
    private String cep;

    @Column(name="tel_agricultor",nullable = false)
    private String telefone;

    public Agricultor(CadastrarAgricultorDto agricultorDto) {
        nome = agricultorDto.nome();
        cpf = agricultorDto.cpf();
        email = agricultorDto.email();
        cep = agricultorDto.endereco();
        telefone = agricultorDto.telefone();
    }



    public void atualizarAgricultor(AtualizarAgricultorDto dto) {
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.cpf() != null)
            cpf = dto.cpf();
        if (dto.email() != null)
            email = dto.email();
        if (dto.endereco() != null)
            cep = dto.endereco();
        if (dto.telefone() != null)
            telefone = dto.telefone();
    }
}
