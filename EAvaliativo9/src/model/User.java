package model;

public abstract class User {
    private static int LIMITE = 3;
    private String nome;
    private int prontuario;
    private Password senha;
    protected int emprestimoDias;

    public User(String nome, int prontuario, String senha) {
        setNome(nome);
        setProntuario(prontuario);
        this.senha = new Password(senha);
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setProntuario(int prontuario) {
        this.prontuario = prontuario;
    }

    public int getProntuario() {
        return this.prontuario;
    }

    protected abstract void setEmprestimoDias();

    public boolean validarSenha(String senha) {
        return this.senha.verificarSenha(senha);
    }

    @Override
    public String toString() {
        return this.nome.toString();
    }
}
