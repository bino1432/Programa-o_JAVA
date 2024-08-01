package sc.senai.revisaospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.revisaospring.model.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
