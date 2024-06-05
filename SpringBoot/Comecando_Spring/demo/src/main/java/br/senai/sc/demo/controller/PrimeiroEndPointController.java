package br.senai.sc.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teste")
public class PrimeiroEndPointController {

    @GetMapping
    public String endpointGet(){
        return "GET - Olá!";
    }

    @PostMapping
    public String endpointPost(@RequestBody String nome){
        return "POST - Olá " + nome + " Seja bem Vindo!";
    }

    @PutMapping("/{id}")
    public String endpointPut(@PathVariable int id,@RequestBody String nome){
        return "PUT - Olá " + nome + " Seja bem Vindo! de ID = " + id;
    }

    @PatchMapping("/{id}")
    public String endpointPatch(@PathVariable int id,@RequestBody String nome){
        return "PATCH - Olá " + nome + " Seja bem Vindo! de ID = " + id;
    }

    @DeleteMapping("/{id}")
    public String endpointDelete(@PathVariable int id){
        return "DELETE - ID = " + id + " Deletado.";
    }
}
