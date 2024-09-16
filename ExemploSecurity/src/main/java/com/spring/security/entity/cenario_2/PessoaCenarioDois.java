package com.spring.security.entity.cenario_2;

import jakarta.persistence.*;

@Entity
public class PessoaCenarioDois {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private boolean temCachorro;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private UsuarioCenarioDois usuario;
}
