package br.edu.fatecpg.TarefaPratica1.repository;
import br.edu.fatecpg.TarefaPratica1.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByTituloContainingIgnoreCase(String tituloLivro);

    List<Livro> findByAutorContainingIgnoreCase(String autorLivro);

    @Query(value = "SELECT * FROM livros WHERE disponibilidade = true", nativeQuery = true)
    List<Livro> buscarLivrosDisponiveis();

    @Query("SELECT l FROM Livro l ORDER BY l.autor")
    List<Livro> livrosPorAutor();
}
