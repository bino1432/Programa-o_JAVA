package Biblioteca;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Midia {

    public boolean emprestado;

    public Midia(int codigo) {
        this.codigo = codigo;
    }

    private static final ArrayList<Midia> midias = new ArrayList<>();

    private int codigo;

    public boolean isEmprestada(){
        return emprestado;
    }

    public void alterarEmprestimo(){
        this.emprestado = !this.emprestado;
    }

    public static Midia procurarMidia(int codigo) {
        for (Midia midia: midias) {
            if(midia.codigo == codigo){
                return midia;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Midia{" +
                "emprestado=" + emprestado +
                ", codigo=" + codigo +
                '}';
    }

    public static final List<Midia> getMidias(){
      return Collections.unmodifiableList(midias);
    };

    public static void addMidia(Midia midia){
        midias.add(midia);
    }

    public static void removeMidia(int codigo){
        for(Midia midia : midias){
            if(midia.codigo == codigo){
                midias.remove(midia);
                break;
            }
        }
    }
}