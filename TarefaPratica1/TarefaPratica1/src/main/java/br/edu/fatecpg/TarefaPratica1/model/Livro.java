package br.edu.fatecpg.TarefaPratica1.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "disponibilidade")
    private boolean disponibilidade;

    public Livro() {
    }


    public Livro(String titulo, String autor, String isbn, boolean disponibilidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponibilidade = disponibilidade;
    }

    public void realizarEmprestimo() {
        if (disponibilidade) {
            this.disponibilidade = false;
        } else {
            System.out.println("O Livro Não Está Disponível");
        }
    }

    public void devolverLivro() {
        this.disponibilidade = true;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", disponibilidade=" + disponibilidade +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }
}
