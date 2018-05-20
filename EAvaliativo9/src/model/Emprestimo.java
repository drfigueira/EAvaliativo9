package model;

public class Emprestimo {
    private User usuario;
    private Exemplar exemplar;

    public Emprestimo(User usuario, Exemplar exemplar) {
        this.usuario = usuario;
        this.exemplar = exemplar;
    }

    public User getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Livro: " + exemplar.getTitulo());
        sb.append("\nExemplar: " + exemplar.getId());
        sb.append("\nEmprestado para: " + usuario.toString());
        sb.append("\n");
        return sb.toString();
    }
}
