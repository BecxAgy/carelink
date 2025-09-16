package com.ws.carelink.core.domain.cuidador;

import java.sql.Date;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.ws.carelink.core.domain.Endereco;
import com.ws.carelink.core.domain.usuario.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cl_caregiver")
public class Caregiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @CPF
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "rg", nullable = false, unique = true)
    private String rg;

    @Column(name = "address", nullable = false)
    private Endereco address;

    @Column(name = "resume_url", nullable = false)
    private String resumeUrl;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;

    @Column(name = "residence_proof_url", nullable = false)
    private String residenceProofUrl;

    @OneToOne(mappedBy = "caregiver", cascade = CascadeType.ALL)
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "cl_caregiver_skill",
        joinColumns = @JoinColumn(name = "caregiver_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;



}
