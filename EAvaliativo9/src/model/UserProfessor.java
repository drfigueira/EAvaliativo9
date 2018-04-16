package model;

public class UserProfessor extends User {

    public UserProfessor(String nome, int prontuario, String senha) {
        super(nome, prontuario, senha);
        setEmprestimoDias();
    }

    protected void setEmprestimoDias() {
        this.emprestimoDias = 30;
    }
}
