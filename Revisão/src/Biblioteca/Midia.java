package Biblioteca;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Midia {

    public boolean emprestado;

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
}