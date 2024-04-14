package br.com.fiap.agroclimate.model;

import br.com.fiap.agroclimate.dto.fazendaDto.AtualizarFazendaDto;
import br.com.fiap.agroclimate.dto.fazendaDto.CadastrarFazendaDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name="Fazenda")
@EntityListeners(AuditingEntityListener.class)
public class Fazenda{

        @Id
        @GeneratedValue
        @Column(name="id_fazenda")
        private Long id;

        @Column(name="cnpj_fazenda", length = 14, nullable = false)
        private String cnpj;

        @Column(name="nm_fazenda", nullable = false, length = 11, unique = true)
        private String nome;

        @Column(name = "cep", nullable = false)
        private String cep;

        @Column(nullable = false, length = 30)
        private String email;

        @Column(precision = 11)
        private String telefone;

        @Column(name="tamanho_fazenda", precision = 9)
        private Integer tamanhoFazenda; //Em Metros!!!!

        public Fazenda(CadastrarFazendaDto fazendaDto) {
                cnpj = fazendaDto.cnpj();
                nome = fazendaDto.nome();
                cep = fazendaDto.cep();
                email = fazendaDto.email();
                telefone = fazendaDto.telefone();
                tamanhoFazenda = fazendaDto.tamanhoFazenda();
        }

        public void atualizarFazenda(AtualizarFazendaDto dto) {
                if (dto.cnpj() != null)
                        cnpj = dto.cnpj();
                if (dto.nome() != null)
                        nome = dto.nome();
                if (dto.cep() != null)
                        cep = dto.cep();
                if (dto.email() != null)
                        email = dto.email();
                if (dto.telefone() != null)
                        telefone = dto.telefone();
                if (dto.tamanhoFazenda() != null)
                        tamanhoFazenda = dto.tamanhoFazenda();
        }
}
