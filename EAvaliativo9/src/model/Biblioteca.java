package model;

public class Biblioteca {
    public static int LIMITE = 10;
    private ListaExemplares[] prateleiras;
    private ListaEmprestimos emprestimos;
    private UserList usuarios = new UserList();
    private int qtdPrateleiras;

    public Biblioteca() {
        prateleiras = new ListaExemplares[LIMITE];
        emprestimos = new ListaEmprestimos(0);
        qtdPrateleiras = 0;
    }

    public boolean addExemplares(Livro livro, int qtdExemplares) {
        boolean add = false;
        if(livro != null) {
            if(qtdPrateleiras < LIMITE) {
                prateleiras[qtdPrateleiras] = new ListaExemplares(qtdExemplares, livro);
                qtdPrateleiras++;
                add = true;
                ListaEmprestimos e = new ListaEmprestimos(qtdObras());
                e.aumentaLimite(emprestimos);
                emprestimos = e;
            }
        }
        return add;
    }

    public int qtdObras() {
        int contador = 0;
        for(int i = 0; i < qtdPrateleiras; i++) {
            contador += prateleiras[i].getQtdExemplar();
        }
        return contador;
    }

    public ListaExemplares getListaExemplares(String titulo) {
        ListaExemplares e = null;
        if(titulo != null) {
            int i = 0;
            boolean deuCerto = false;
            while(i < LIMITE && !deuCerto) {
                if(prateleiras[i].getAt(0).getTitulo().equals(titulo)) {
                    e = prateleiras[i];
                    deuCerto = true;
                }
                i++;
            }
        }
        return e;
    }

    public boolean addUsuario(User u) {
        return usuarios.addUsuario(u);
    }


    public boolean emprestar(String titulo, int prontuario) {
        boolean deuCerto = false;
        Exemplar e = getListaExemplares(titulo).exemplarDisponivel();
        User u = usuarios.getUsuario(prontuario);
        if(e != null && u != null) {
            deuCerto = emprestimos.registraEmprestimo(u, e);
            e.setDisponivel(false);
        }
        return deuCerto;
    }

    public boolean devolver(int prontuario, String titulo) {
        boolean deuCerto = false;
        Exemplar e = emprestimos.registraDevolucao(prontuario, titulo);
        if(e != null) {
            e.setDisponivel(true);
            deuCerto = true;
        }
        return deuCerto;
    }

    public String relatorioAluno() {
        return usuarios.toString();
    }

    public String relatorioLivrosEmprestados() {
        return emprestimos.toString();
    }

    public String relatorioEmprestimos() {
        return emprestimos.relatorioEmprestimos();
    }

    public String relatorioExemplares() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < qtdPrateleiras; i++) {
            sb.append("Livro: ");
            sb.append(prateleiras[i].getAt(0).getTitulo());
            sb.append(" - x");
            sb.append(prateleiras[i].qtdDisponivel());
            sb.append("\n");
        }
        return sb.toString();
    }

}
