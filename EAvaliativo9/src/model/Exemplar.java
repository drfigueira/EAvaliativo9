package model;

public class Exemplar extends Livro {
    private boolean disponivel;
    private String id;

    public Exemplar(String nomeAutor, String titulo, String subtitulo, String editora, String isbn, String id) {
        super(nomeAutor, titulo, subtitulo, editora, isbn);
        this.disponivel = true;
        setId(id);
    }

    public Exemplar(Livro livro, String id) {
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
        return this.id;
    }

    private void setId(String id) {
        this.id = getIsbn() + "-" + id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Livro: " + getTitulo());
        sb.append(" " + getSubtitulo());
        sb.append("\nAutor: " + getNomeAutor());
        sb.append("\nEditora: " + getEditora());
        sb.append("\nId: " + getId());
        sb.append("\n");
        return sb.toString();
    }
}
