package model;

public class Livro {
    private String nomeAutor;
    private String titulo;
    private String subtitulo;
    private String editora;
    private String isbn;

    public Livro(String nomeAutor, String titulo, String subtitulo, String editora, String isbn) {
        setNomeAutor(nomeAutor);
        setTitulo(titulo);
        setSubtitulo(subtitulo);
        setEditora(editora);
        setIsbn(isbn);
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    private void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    private void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getEditora() {
        return editora;
    }

    private void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    private void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
