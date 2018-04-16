package model;

public class Biblioteca {
    private static int LIMITE = 10;
    private ListaExemplares[] biblioteca;
    private int prateleirasOcupadas;
    private User[] usuarios;
    private int usuariosCadastrados;

    public Biblioteca() {
        this.biblioteca = new ListaExemplares[LIMITE];
        this.usuarios = new User[LIMITE];
        this.prateleirasOcupadas = 0;
        this.usuariosCadastrados = 0;
    }

    public boolean addExemplares(int qtdExemplar, Livro livro) {
        boolean deuCerto = false;
        if(prateleirasOcupadas < LIMITE) {
            biblioteca[prateleirasOcupadas] = new ListaExemplares(qtdExemplar, livro);
            this.prateleirasOcupadas++;
            deuCerto = true;
        }
        return deuCerto;
    }

    public boolean addUsuario(User user) {
        boolean deuCerto = false;
        if(usuariosCadastrados < LIMITE) {
            usuarios[usuariosCadastrados] = user;
            this.usuariosCadastrados++;
            deuCerto = true;
        }
        return deuCerto;
    }

    public boolean emprestimoExemplar(String titulo, int prontuario, String senha) {
        boolean deuCerto = false;
        Exemplar novo = null;
        int i = 0;
        int j = 0;
        while(i < this.prateleirasOcupadas && !deuCerto) {
            if(biblioteca[i].getAt(0).getTitulo().equals(titulo)) {
                while(j < this.usuariosCadastrados && !deuCerto) {
                    if(usuarios[j].getProntuario() == prontuario) {
                        if(usuarios[j].validarSenha(senha)) {
                            if(usuarios[j].isFull()) {
                                novo = biblioteca[i].emprestarExemplar();
                                if(novo != null) {
                                    usuarios[j].setExemplares(novo);
                                }
                            }
                        }
                    }
                    j++;
                }
            }
            i++;
        }
        return deuCerto;
    }

    public boolean devolucaoExemplar(Exemplar exemplar) {
        boolean deuCerto = false;
        int i = 0;
        while(i < this.prateleirasOcupadas && !deuCerto) {
            if(biblioteca[i].getAt(0).getTitulo().equals(exemplar.getTitulo())) {
                biblioteca[i].devolverExemplar(exemplar);
                deuCerto = true;
            }
            i++;
        }
        return deuCerto;
    }

}
