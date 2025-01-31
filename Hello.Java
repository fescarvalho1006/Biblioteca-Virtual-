class Hello {
    public static void main(String[] args) {
        system.out.print ("Hello World !!!");
        system.out.println ("Fernanda Carvalho");
    }
}
package biblioteca;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Biblioteca {
	private ArrayList<Livros> livros;

	public Biblioteca() {
		this.livros = new ArrayList<Livros>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public Terror leTerror(){

		String [] valores = new String [3];
		String [] nomeVal = {"Titulo", "Paginas", "Autor"};
		valores = leValores (nomeVal);

		int pags = this.retornaInteiro(valores[1]);

		Terror terror = new Terror (valores[0],pags,valores[2]);
		return terror;
	}

	public Aventura leAventura (){

		String [] valores = new String [3];
		String [] nomeVal = {"Titulo", "Paginas", "Autor"};
		valores = leValores (nomeVal);

		int pags = this.retornaInteiro(valores[1]);

		Aventura aventura = new Aventura (valores[0],pags,valores[2]);
		return aventura;
	}
	
	public Ficcao leFiccao(){

		String [] valores = new String [3];
		String [] nomeVal = {"Titulo", "Paginas", "Autor"};
		valores = leValores (nomeVal);

		int pags = this.retornaInteiro(valores[1]);

		Ficcao ficcao = new Ficcao (valores[0],pags,valores[2]);
		return ficcao;
	}
	
	public Comedia leComedia(){

		String [] valores = new String [3];
		String [] nomeVal = {"Titulo", "Paginas", "Autor"};
		valores = leValores (nomeVal);

		int pags = this.retornaInteiro(valores[1]);

		Comedia comedia = new Comedia (valores[0],pags,valores[2]);
		return comedia;
	}
	
	
	
	
	

	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); 
			return true;
		} catch (NumberFormatException e) { 
			return false;
		}
	}
	public int retornaInteiro(String entrada) { 

		
		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro.");
		}
		return Integer.parseInt(entrada);
	}

	public void salvaLivros(ArrayList<Livros> livros){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("biblioteca.dat"));
			for (int i=0; i < livros.size(); i++)
				outputStream.writeObject(livros.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Erro ao criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Livros> recuperaLivros (){
		ArrayList<Livros> livrosTemp = new ArrayList<Livros>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("biblioteca.dat"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Livros) {
					livrosTemp.add((Livros) obj);
				}   
			}          
		} catch (EOFException ex) { 
			System.out.println("Arquivo Carregado.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com livros não existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return livrosTemp;
		}
	}

	public void menuBiblioteca(){

		String menu = "";
		String entrada;
		int    opc1, opc2, opc3, opc4;

		do {
			menu = "Controle Biblioteca\n" +
					"Opções:\n" + 
					"1. Inserir Livros\n" +
					"2. Exibir Livros\n" +
					"3. Limpar Livros\n" +
					"4. Salvar Livros\n" +
					"5. Carregar Livros\n" +
					"9. Exit";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:
				menu = "Inserir Livros\n" +
						"Opções:\n" + 
						"1. Aventura\n" +
						"2. Terror\n" + 
						"3. Ficção\n" + 
						"4. Comédia";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);
				opc3 = this.retornaInteiro(entrada);
				
				switch (opc2){
				case 1: livros.add((Livros)leAventura());
				break;
				case 2: livros.add((Livros)leTerror());
				break;
				case 3: livros.add((Livros)leFiccao());
				break;
				case 4: livros.add((Livros)leComedia());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Nenhum Livro para Salvar");
				}

				break;
			case 2: 
				if (livros.size() == 0) {
					JOptionPane.showMessageDialog(null,"Insira um Livro");
					break;
				}
				String dados = "";
				for (int i=0; i < livros.size(); i++)	{
					dados += livros.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: 
				if (livros.size() == 0) {
					JOptionPane.showMessageDialog(null,"Insira um Livro primeiro");
					break;
				}
				livros.clear();
				JOptionPane.showMessageDialog(null,"Dados Apagados!!");
				break;
			case 4: 
				if (livros.size() == 0) {
					JOptionPane.showMessageDialog(null,"Insira um Livro primeiro");
					break;
				}
				salvaLivros(livros);
				JOptionPane.showMessageDialog(null,"Dados Salvos!!");
				break;
			case 5: 
				livros = recuperaLivros();
				if (livros.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Done.");
				break;
			}
		} while (opc1 != 9);
	}


	public static void main (String [] args){

		Biblioteca Fernanda = new Biblioteca ();
		Fernanda.menuBiblioteca();

	}

}