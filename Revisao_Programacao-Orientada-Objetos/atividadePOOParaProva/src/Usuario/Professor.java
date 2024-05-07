package Usuario;

import resto.Disciplina;
import resto.Turma;

public class Professor extends Usuario{

    private Disciplina disciplina;
    private Turma turma;

    public Professor(String nome, int idade, String endereco, Disciplina disciplina, Turma turma) {
        super(nome, idade, endereco);
        this.disciplina = disciplina;
        this.turma = turma;
    }
}
