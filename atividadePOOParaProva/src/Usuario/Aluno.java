package Usuario;

import resto.Nota;
import resto.Turma;

import java.util.ArrayList;

public class Aluno extends Usuario{

    private Turma turma;

    ArrayList<Nota> notas = new ArrayList<Nota>();

    public Aluno(String nome, int idade, String endereco, Turma turma) {
        super(nome, idade, endereco);
        this.turma = turma;
    }
}
