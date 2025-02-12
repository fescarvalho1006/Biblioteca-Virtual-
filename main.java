import br.com.fecaf.Biblioteca;
import br.com.fecaf.Livro;
import br.com.fecaf.Usuario;

import java.util.Scanner;

public class main {
    public static void main(String[]args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        //Adicionando alguns livros e usuarios para teste
        biblioteca.adicionarlivro(new Livro("O Hobbit", "J.R.R. Tolkin"));
        biblioteca.adicionarlivro(new Livro("1984", "George Orwell"));
        biblioteca.adicionarlivro(new Usuario("Fernanda"));
        biblioteca.adicionarlivro(new Usuario("Lili"));
    }
        //Interação com o usuario
        while (true) {
            System.out.println("1. Alugar livro");
            System.out.println("2. Devolver livro");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            if (opcao == 1) {
                System.out.println("Digite o nome do usuario:");
                String nomeUsuario = scanner.nextLine();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    System.out.print("Digite o titulo do livro:");
                    String tituloLivro = scanner.nextLine();
                    Livro livro = biblioteca.buscarlivro(tituloLivro);

                    if (usuario != null){
                        usuario.alugarlivro(livro);
                    } else{
                        System.out.println("Livro não encontrado.");
                    }
                } else {
                    System.out.println("Usuario não encontrado.");
                }
         } else if (opcao == 2) {
                System.out.println("Digite o nome do usuario:");
                String nomeUsuario = scanner.nextLine();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    usuario.devolverLivro();

                } else  {
                    System.out.println("Usuario não encontrado.");

                } else if (opcao == 3) {
                    System.out.println(" Saindo...");
                    break;
                } else {
                    System.out.println("opçao invalida.");
                }
                scanner.close();
            }
    }
}