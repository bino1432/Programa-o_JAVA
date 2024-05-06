package resto;

import Usuario.Aluno;
import Usuario.Professor;

import java.util.ArrayList;

public class Turma {

    private Professor professor;
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public Turma(Professor professor, ArrayList<Aluno> alunos){
        this.professor = professor;
        this.alunos = alunos;
    }

    public Turma(){}

    public void adicionarAlunaATurma(Aluno aluno){
            alunos.add(aluno);
    }

    public void alterarProfessor(Professor professor){
        this.professor = professor;
    }

}
