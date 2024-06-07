package br.senai.sc.demo.model;

import jakarta.persistence.*;

@Entity
// Associa esta classe com uma tabela do banco de dados,
// o nome da classe e da tabela devem ser iguais e com letras minusculas e undeline
// no espaçamento
// (nome de classe e camelCase é associado mesmo com a letra maiuscula e sem o underLine)

// @Table(name = "tb_usuario")
// fala qual a tabela do banco que se associa com a classe (não obrigatório)

//@Column(name = "nome_pet")
// Fala a qual coluna o atributo se refere (não obrigatório)
// Tambem passa informações a nivel de banco das colunas

// @Id - Fala qual a primary key da classe

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(name = "passsword")
    private String senha;
    @Column(precision = 11, updatable = false, unique = true)
    private Long cpf;
    @Column(length = 25)
    private String nomePet;
}
