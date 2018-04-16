package model;

public class ListaExemplares {
    private static int LIMITE = 10;
    private Exemplar[] exemplares;
    private int qtdExemplar;

    public ListaExemplares(int qtdExemplar, Livro livro) {
        setQtdExemplar(qtdExemplar);
        this.exemplares = new Exemplar[this.getQtdExemplar()];
        prateleiraExemplar(livro);

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

    private void prateleiraExemplar(Livro livro) {
        for(int i = 0; i < getQtdExemplar(); i++) {
            exemplares[i] = new Exemplar(livro, (i+1));
        }
    }

    public Exemplar emprestarExemplar() {
        int i = 0;
        Exemplar exemplar = null;
        while(i < this.qtdExemplar && exemplar == null) {
            if(exemplares[i].getDisponivel()) {
                exemplares[i].setDisponivel(false);
                exemplar = exemplares[i];
            }
            i++;
        }
        return exemplar;
    }

    public boolean devolverExemplar(Exemplar exemplar) {
        boolean deuCerto = false;
        int i = 0;
        while(i < this.qtdExemplar && !deuCerto) {
            if(exemplar.toString().equals(exemplares[i].toString())) {
                exemplares[i].setDisponivel(true);
                deuCerto = true;
            }
            i++;
        }
        return deuCerto;
    }

}
