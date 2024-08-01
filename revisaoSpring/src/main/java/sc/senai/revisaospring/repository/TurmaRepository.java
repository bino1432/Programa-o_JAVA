package sc.senai.revisaospring.repository;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.revisaospring.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
