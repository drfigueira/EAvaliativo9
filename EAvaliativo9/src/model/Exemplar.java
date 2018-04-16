package model;

public class Exemplar extends Livro {
    private boolean disponivel;
    private int id;

    public Exemplar(String nomeAutor, String titulo, String subtitulo, String editora, String isbn, int id) {
        super(nomeAutor, titulo, subtitulo, editora, isbn);
        this.disponivel = true;
        setId(id);
    }

    public Exemplar(Livro livro, int id) {
        super(livro.getNomeAutor(), livro.getTitulo(), livro.getSubtitulo(), livro.getEditora(), livro.getIsbn());
        this.disponivel = true;
        setId(id);
    }

    public void setDisponivel(boolean status) {
        this.disponivel = status;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }

    public String getId() {
        return (getIsbn() + "-" + id);
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Livro: " + getTitulo());
        sb.append(" " + getSubtitulo());
        sb.append("\nAutor: " + getNomeAutor());
        sb.append("\nEditora: " + getEditora());
        sb.append("\nId: " + getId());
        return sb.toString();
    }
}
