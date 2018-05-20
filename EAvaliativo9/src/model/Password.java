package model;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
    private byte[] senha;

    public Password(String senha) {
        try {
            if(senha == null || senha.isEmpty()) {
                senha = "senha";
            }
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            this.senha = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public boolean verificarSenha(String senha) {
        boolean retorno = false;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());

            byte[] palpite = md.digest();

            retorno = this.senha.length == palpite.length;
            for(int i = 0; i < this.senha.length && retorno; i++) {
                retorno = this.senha[i] == palpite[i];
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return retorno;
    }
}
