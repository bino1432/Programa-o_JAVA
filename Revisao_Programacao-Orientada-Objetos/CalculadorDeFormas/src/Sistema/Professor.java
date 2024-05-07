package Sistema;

public class Professor {

    private String senha;

    public boolean login(String tentativa){
        for(int tentativas = 1; tentativas <= 3; tentativas++) {
            if (senha.equals(tentativa)) {
                return true;
            }
        }
        return false;
    }

    public Professor(String senha){
        this.senha = senha;
    }
}
