package com.ws.carelink.core.domain.cuidador;

import java.sql.Date;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.ws.carelink.core.domain.Endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cl_cuidador")
public class Cuidador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @CPF
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "rg", nullable = false, unique = true)
    private String rg;

    @Column(name = "endereco", nullable = false)
    private Endereco endereco;

    @Column(name = "curriculo_url", nullable = false)
    private String curriculoUrl;

    @Column(name = "foto_url", nullable = false)
    private String fotoUrl;

    @Column(name = "comprovante_residencia_url", nullable = false)
    private String comprovanteResidenciaUrl;

    @ManyToMany
    @JoinTable(
        name = "cuidador_habilidade",
        joinColumns = @JoinColumn(name = "cuidador_id"),
        inverseJoinColumns = @JoinColumn(name = "habilidade_id")
    )
    private List<Habilidade> habilidades;



}
