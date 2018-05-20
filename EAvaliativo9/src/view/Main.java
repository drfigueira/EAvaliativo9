package view;

import com.sun.org.apache.xpath.internal.SourceTree;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca campus = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int menu;
        int submenu;

        //User
        String nome, senha;
        int prontuario;

        //Exemplar
        String nomeAutor, titulo, subtitulo, editora, isbn;
        int qtdObras;

        campus.addUsuario(new UserAluno("diego", 171,"123"));
        campus.addExemplares(new Livro("eu", "titulo", "sub", "editora", "123"), 5);
        campus.addExemplares(new Livro("vc", "java", "como programar", "editora", "321"), 5);

        do{
            System.out.println("1. Cadastrar usuário\n2. Cadastrar obra\n3. Emprestar obra\n4. Devolver obra\n5. Gerar relatório\n0. Sair");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    do{
                        System.out.println("\n*****CADASTRAR_USUÁRIO*****");
                        System.out.println("1. Cadastrar aluno\n2. Cadastrar servidor\n3. Cadastrar professor\n0. Sair");
                        submenu = sc.nextInt();
                        switch (submenu) {
                            case 1:
                                System.out.println("Digite o nome: ");
                                nome = sc.next();
                                System.out.println("Digite o prontuário: ");
                                prontuario = sc.nextInt();
                                System.out.println("Digite a senha: ");
                                senha = sc.next();
                                System.out.println(campus.addUsuario(new UserAluno(nome, prontuario, senha))? "Usuário cadastrado" : "Usuário não cadastrado");
                                break;
                            case 2:
                                System.out.println("Digite o nome: ");
                                nome = sc.next();
                                System.out.println("Digite o prontuário: ");
                                prontuario = sc.nextInt();
                                System.out.println("Digite a senha: ");
                                senha = sc.next();
                                System.out.println(campus.addUsuario(new UserServidor(nome, prontuario, senha))? "Usuário cadastrado" : "Usuário não cadastrado");
                                break;
                            case 3:
                                System.out.println("Digite o nome: ");
                                nome = sc.next();
                                System.out.println("Digite o prontuário: ");
                                prontuario = sc.nextInt();
                                System.out.println("Digite a senha: ");
                                senha = sc.next();
                                System.out.println(campus.addUsuario(new UserProfessor(nome, prontuario, senha))? "Usuário cadastrado" : "Usuário não cadastrado");
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("OPÇÃO INVÁLIDA");
                        }
                    }while (submenu != 0);
                    break;
                case 2:
                    System.out.println("\n*****CADASTRAR_OBRA*****");
                    System.out.println("Digite o título: ");
                    titulo = sc.next();
                    System.out.println("Digite o subtítulo: ");
                    subtitulo = sc.next();
                    System.out.println("Digite nome do autor: ");
                    nomeAutor = sc.next();
                    System.out.println("Digite a editora: ");
                    editora  = sc.next();
                    System.out.println("Digite ISBN: ");
                    isbn = sc.next();
                    System.out.println("Digite quantidade de obras: ");
                    qtdObras = sc.nextInt();
                    campus.addExemplares(new Livro(nomeAutor, titulo, subtitulo, editora, isbn), qtdObras);
                    break;
                case 3:
                    System.out.println("\n*****EMPRESTIMO*****");
                    System.out.println("Digite o prontuário: ");
                    prontuario = sc.nextInt();
                    System.out.println("Digite titulo da obra: ");
                    titulo = sc.next();
                    System.out.println(campus.emprestar(titulo, prontuario)? "Emprestimo realizado com sucesso" : "Falha ao emprestar");
                    break;
                case 4:
                    System.out.println("\n*****DEVOLUÇAO*****");
                    System.out.println("Digite o prontuário: ");
                    prontuario = sc.nextInt();
                    System.out.println("Digite titulo da obra: ");
                    titulo = sc.next();
                    System.out.println(campus.devolver(prontuario, titulo)? "Devoluçao realizado com sucesso" : "Falha ao devolver");
                    break;
                case 5:
                    System.out.println("\n*****RELATÓRIO*****");
                    do{
                        System.out.println("1. Alunos\n2. Livros emprestados\n3. Livros e quantidade de exemplares disponíveis\n4. Alunos com livros emprestados\n0. Sair");
                        submenu = sc.nextInt();
                        switch (submenu) {
                            case 1:
                                System.out.println(campus.relatorioAluno());
                                break;
                            case 2:
                                System.out.println(campus.relatorioLivrosEmprestados());
                                break;
                            case 3:
                                System.out.println(campus.relatorioExemplares());
                                break;
                            case 4:
                                System.out.println(campus.relatorioEmprestimos());
                                break;
                            case 0:
                                break;
                            default:
                        }
                    }while(submenu != 0);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
            }

        }while (menu != 0);

    }
}
