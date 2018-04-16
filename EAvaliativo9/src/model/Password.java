package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
    private String senha;

    public Password(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            this.senha = md.digest().toString();
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
            retorno = this.senha.equals(md.digest().toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return retorno;
    }
}