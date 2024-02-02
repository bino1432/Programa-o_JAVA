package Biblioteca;

import java.util.ArrayList;

public abstract class Midia {

    public boolean emprestado;

    public static final ArrayList<Midia> midias = new ArrayList<>();

    public boolean isEmprestada(){
        return emprestado;
    }

    public void alterarEmprestimo(){
        this.emprestado = !this.emprestado;
    }
}
