package model;

public class ListaExemplares {
    private static int LIMITE = 10;
    private Exemplar[] exemplares;
    private int qtdExemplar;

    public ListaExemplares(int qtdExemplar, Livro livro) {
        setQtdExemplar(qtdExemplar);
        this.exemplares = new Exemplar[this.getQtdExemplar()];
        criarPrateleira(livro);
    }

    private void setQtdExemplar(int qtdExemplar) {
        if(qtdExemplar < 1) {
            this.qtdExemplar = 1;
        }else if(qtdExemplar > LIMITE) {
            this.qtdExemplar = LIMITE;
        }else {
            this.qtdExemplar = qtdExemplar;
        }
    }

    public int getQtdExemplar() {
        return this.qtdExemplar;
    }

    public Exemplar getAt(int pos) {
        return this.exemplares[pos];
    }

    private void criarPrateleira(Livro livro) {
        for(int i = 0; i < getQtdExemplar(); i++) {
            exemplares[i] = new Exemplar(livro, String.valueOf(i+1));
        }
    }

    public Exemplar exemplarDisponivel() {
        Exemplar e = null;
        int i = 0;
        boolean disponivel = false;
        while (i < LIMITE && !disponivel) {
            if(exemplares[i].getDisponivel()) {
                e = exemplares[i];
                disponivel = true;
            }
            i++;
        }
        return e;
    }

    public int qtdDisponivel() {
        int e = 0;
        for(int i = 0; i < qtdExemplar; i++) {
            if(exemplares[i].getDisponivel()) {
                e++;
            }
        }
        return e;
    }
}
