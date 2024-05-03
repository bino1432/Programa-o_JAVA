package resto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disciplina {

    private String nome;
    private int codigoDisciplina;
    private int cargaHoraria;

    private static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Disciplina(String nome, int codigoDisciplina, int cargaHoraria) {
        this.nome = nome;
        this.codigoDisciplina = codigoDisciplina;
        this. cargaHoraria = cargaHoraria;
    }

    public static void adicionarALista(Disciplina disciplina){
        disciplinas.add(disciplina);
    }

    public static List<Disciplina> getList(){
        return Collections.unmodifiableList(disciplinas);
    }
}
