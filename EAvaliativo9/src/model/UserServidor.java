package model;

public class UserServidor extends User {

    public UserServidor(String nome, int prontuario, String senha) {
        super(nome, prontuario, senha);
        setEmprestimoDias();
    }

    protected void setEmprestimoDias() {
        this.emprestimoDias = 4;
    }
}
