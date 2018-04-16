package model;

public class UserAluno extends User {

    public UserAluno(String nome, int prontuario, String senha) {
        super(nome, prontuario, senha);
        setEmprestimoDias();
    }

    protected void setEmprestimoDias() {
        this.emprestimoDias = 7;
    }
}
