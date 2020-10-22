package com.example.demoproject.aprendendo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Builder
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Usuario {
    private UUID id;
    private String nome;
    private String email;

    public Usuario(@JsonProperty("id") UUID id,
                   @JsonProperty("nome") String nome,
                   @JsonProperty("email") String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}


