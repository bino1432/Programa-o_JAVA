package Usuario;

import resto.Disciplina;
import resto.Turma;

import java.util.ArrayList;

public class Secretario extends Usuario{

    private int qtdBoletinsGerados;

    public Secretario(String nome, int idade, String endereco, int qtdBoletinsGerados) {
        super(nome, idade, endereco);
        this.qtdBoletinsGerados = qtdBoletinsGerados;
    }

    public String cadastrarDisciplina(String nome, int codigoDisciplina, int cargaHoraria) {
        for (Disciplina disciplina : Disciplina.getList()){
            if (disciplina.equals(nome)){
                return "Disciplina já existente";
            }
        }
        Disciplina disciplina = new Disciplina(nome, codigoDisciplina, cargaHoraria);
        Disciplina.adicionarALista(disciplina);
        return "Disciplina Cadastrada";
    }

    public String criarNovaTurma(Professor professor, ArrayList<Aluno> alunos) {
        Turma turma = new Turma(professor, alunos);
        return "Turma criada com sucesso";
    }

    public String criarNovaTurma() {
        Turma turma = new Turma();
        return "Turma vazia criada com sucesso";
    }

    public String adicionarAlunaATurma(Turma turma, Aluno aluno){
        turma.adicionarAlunaATurma(aluno);
        return "Aluno adicionado na turma com sucesso";
    }

    public String alterarProfessor(Turma turma, Professor professor){
        turma.alterarProfessor(professor);
        return "Professor alterado com sucesso";
    }
}
