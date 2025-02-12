package br.com.fecaf;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;

    public Biblioteca(){
        setLivros(new ArrayList<Livro>());
        setUsuarios(new ArrayList<usuarios>());
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public void adicionarlivro(livros livros) {
        livros.add(livros);
        Livro livro;
        System.out.println(("livro adicionado:" + Livro.getTitulo()));
    }
    public void adicionsrUsuario (Usuario usuario) {
        usuario.add(usuario);
        System.out.println(("usuario cadastrado:" + usuario.getNome()));

    }
    public Livro buscarlivro(String titulo) {
        for (livros livro; livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }

        return null;
    }

    public Usuario buscarUsuario (String nome) {
        for (usuarios usuarios: usuarios) {
            if (Usuario.getNome().equals(nome)) {
                return usuarios
            }
        }
        return null;
    }

    }
}
