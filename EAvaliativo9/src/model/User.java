package model;

public abstract class User {
    private static int LIMITE = 3;
    private String nome;
    private int prontuario;
    private Password senha;
    protected int emprestimoDias;
    private Exemplar[] exemplares;
    private int qtdExemplares;

    public User(String nome, int prontuario, String senha) {
        setNome(nome);
        setProntuario(prontuario);
        this.senha = new Password(senha);
        this.qtdExemplares = 0;
        exemplares = new Exemplar[LIMITE];
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

    public int getQtdExemplares() {
        return this.qtdExemplares;
    }

    public boolean isFull() {
        return getQtdExemplares() < LIMITE;
    }

    protected abstract void setEmprestimoDias();

    public boolean validarSenha(String senha) {
        return this.senha.verificarSenha(senha);
    }

    public boolean setExemplares(Exemplar exemplar) {
        boolean deuCerto = false;
        if(this.qtdExemplares < LIMITE && exemplar != null) {
            this.exemplares[this.qtdExemplares] = exemplar;
            this.qtdExemplares++;
            deuCerto = true;
        }
        return deuCerto;
    }

}
