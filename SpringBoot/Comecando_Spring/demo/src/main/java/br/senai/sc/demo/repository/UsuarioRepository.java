package br.senai.sc.demo.repository;

import br.senai.sc.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// serve para avisar que é um repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
