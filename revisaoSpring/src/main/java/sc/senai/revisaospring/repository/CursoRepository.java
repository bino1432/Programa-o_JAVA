package sc.senai.revisaospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.revisaospring.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
