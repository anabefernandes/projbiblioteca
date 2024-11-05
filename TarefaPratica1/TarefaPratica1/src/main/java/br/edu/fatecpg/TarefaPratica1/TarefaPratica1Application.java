package br.edu.fatecpg.TarefaPratica1;

import br.edu.fatecpg.TarefaPratica1.model.Biblioteca;
import br.edu.fatecpg.TarefaPratica1.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TarefaPratica1Application implements CommandLineRunner {

	@Autowired
	private Biblioteca bibliotecaService;

	public static void main(String[] args) {
		SpringApplication.run(TarefaPratica1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Livro livro1 = new Livro("O Pedroso", "Paulo Coelho", "123456789", true);
		Livro livro2 = new Livro("Dom Dom Dom", "Miguel de Cervantes", "987654321", true);
		Livro livro3 = new Livro("O Príncipe Pequeno", "Antoine de Saint-Exupéry", "987654457", true);

		bibliotecaService.addLivro(livro1);
		bibliotecaService.addLivro(livro2);
		bibliotecaService.addLivro(livro3);


		System.out.println("Todos os livros disponíveis:");
		bibliotecaService.disponibilidade().forEach(System.out::println);


		System.out.println("\nRealizando empréstimo do livro: " + livro1.getTitulo());
		livro1.realizarEmprestimo();
		bibliotecaService.addLivro(livro1);


		System.out.println("\nLivros disponíveis após o empréstimo:");
		bibliotecaService.disponibilidade().forEach(System.out::println);


		System.out.println("\nDevolvendo o livro: " + livro1.getTitulo());
		livro1.devolverLivro();
		bibliotecaService.addLivro(livro1);


		System.out.println("\nLivros disponíveis após a devolução:");
		bibliotecaService.disponibilidade().forEach(System.out::println);


		System.out.println("\nRemovendo o livro: " + livro3.getTitulo());
		bibliotecaService.removerLivro(livro3);


		System.out.println("\nLivros disponíveis após a remoção:");
		bibliotecaService.disponibilidade().forEach(System.out::println);


		System.out.println("\nBuscando livros po autor:");
		bibliotecaService.buscarPorAutor("Paulo Coelho").forEach(System.out::println);


		System.out.println("\nBuscando livros por titulo:");
		bibliotecaService.buscarPorTitulo("Dom Quixote").forEach(System.out::println);


		System.out.println("\nListando todos os livros ordenados por autor:");
		bibliotecaService.listarLivrosOrdenadosPorAutor().forEach(System.out::println);
	}
}
