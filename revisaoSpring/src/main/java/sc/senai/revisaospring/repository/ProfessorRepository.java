package sc.senai.revisaospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.revisaospring.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
