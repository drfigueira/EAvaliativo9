package view;

import model.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca campus = new Biblioteca();

        campus.addExemplares(5, new Livro("nomeAutor", "Titulo", "subtitulo", "Editora",
                "1234567890123"));
        campus.addUsuario(new UserAluno("Diego", 1710087, "minhaSenha"));

        campus.emprestimoExemplar("Titulo", 1710097, "minhaSenha");


    }
}
