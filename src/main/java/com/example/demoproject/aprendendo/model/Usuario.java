package com.example.demoproject.aprendendo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Builder
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String nome;
    @Column
    private String email;

    public Usuario(@JsonProperty("id") UUID id,
                   @JsonProperty("nome") String nome,
                   @JsonProperty("email") String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}


