package model;

public class ListaEmprestimos {
    private Emprestimo[] emprestimo;
    private int qtdEmprestimo;
    private int limite;

    public ListaEmprestimos(int limite) {
        this.limite = limite;
        emprestimo = new Emprestimo[limite];
        qtdEmprestimo = 0;
    }

    public boolean registraEmprestimo(User u, Exemplar e) {
        boolean deuCerto = false;
        if(u != null && e != null) {
            emprestimo[qtdEmprestimo] = new Emprestimo(u, e);
            deuCerto = true;
            qtdEmprestimo++;
        }
        return deuCerto;
    }

    public void aumentaLimite(ListaEmprestimos e) {
        if(e != null) {
            for(int i = 0; i < e.limite; i++) {
                emprestimo[i] = e.getAt(i);
            }
        }
    }

    public Emprestimo getAt(int pos) {
        return pos < 0 || pos > limite? null : emprestimo[pos];
    }

    public Exemplar registraDevolucao(int prontuario, String titulo) {
        boolean deuCerto = false;
        int i = 0;
        Exemplar e = null;
        while(i < qtdEmprestimo && !deuCerto) {
            if(emprestimo[i].getUsuario().getProntuario() == prontuario) {
                if(emprestimo[i].getExemplar().getTitulo().equals(titulo)) {
                    e = emprestimo[i].getExemplar();
                    deuCerto = true;
                    remove(i);
                }
            }
            i++;
        }
        return e;
    }

    private void remove(int pos) {
        Emprestimo[] novo = new Emprestimo[limite-1];
        if(pos >= 0 && pos < qtdEmprestimo) {
            int j = 0;
            for(int i = 0; i < qtdEmprestimo; i++) {
                if(i != pos) {
                    novo[j] = emprestimo[i];
                    j++;
                }
            }
            emprestimo = novo;
            qtdEmprestimo--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < qtdEmprestimo; i++) {
            sb.append(emprestimo[i].getExemplar().getTitulo() + "\n");
        }
        return sb.toString();
    }

    public String relatorioEmprestimos() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < qtdEmprestimo; i++) {
            sb.append(emprestimo[i].toString() + "\n");
        }
        return sb.toString();
    }

}
