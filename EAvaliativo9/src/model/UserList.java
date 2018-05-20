package model;

public class UserList {
    private static int LIMITE = 10;
    private User[] usuarios;
    private int qtdUsuarios;

    public UserList() {
        usuarios = new User[LIMITE];
        this.qtdUsuarios = 0;
    }

    public boolean addUsuario(User user) {
        boolean deuCerto = false;
        if(user != null) {
            if (this.qtdUsuarios < LIMITE && !contains(user.getProntuario())) {
                usuarios[this.qtdUsuarios] = user;
                this.qtdUsuarios++;
                deuCerto = true;
            }
        }
        return deuCerto;
    }

    private boolean contains(int prontuario) {
        boolean existe = false;
        int i = 0;
        while(i < this.qtdUsuarios && !existe) {
            if(usuarios[i].getProntuario() == prontuario) {
                existe = true;
            }
            i++;
        }
        return existe;
    }

    public User getUsuario(int prontuario) {
        User user = null;
        int i = 0;
        while(i < this.qtdUsuarios && user == null) {
            if(usuarios[i].getProntuario() == prontuario) {
                user = usuarios[i];
            }
            i++;
        }
        return user;
    }

    public User getAt(int pos) {
        return pos < this.qtdUsuarios ? usuarios[pos] : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < qtdUsuarios; i++) {
            sb.append("Nome: " + usuarios[i].toString());
            sb.append(" Prontuário: " + usuarios[i].getProntuario());
            sb.append("\n");
        }
        return sb.toString();
    }
}
