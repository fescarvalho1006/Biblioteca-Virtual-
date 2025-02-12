package br.com.fecaf;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String titulo, String autor) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setDisponivel(true);

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Livro {" +
                "titulo='" + titulo + '\'' +
                ",autor= '" + autor + '\'' +
                ",disponivel=" + disponivel +
                '}';
    }
}
