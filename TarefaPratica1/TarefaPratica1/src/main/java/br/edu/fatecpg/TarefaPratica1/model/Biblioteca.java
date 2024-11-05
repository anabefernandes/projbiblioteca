package br.edu.fatecpg.TarefaPratica1.model;
import br.edu.fatecpg.TarefaPratica1.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Biblioteca {

    @Autowired
    private LivroRepository repositorio;

    public void addLivro(Livro livro) {
        repositorio.save(livro);
    }

    public void removerLivro(Livro livro) {
        repositorio.delete(livro);
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return repositorio.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Livro> buscarPorAutor(String autor) {
        return repositorio.findByAutorContainingIgnoreCase(autor);
    }

    public List<Livro> listarLivrosOrdenadosPorAutor() {
        return repositorio.livrosPorAutor();
    }

    public List<Livro> disponibilidade() {
        return repositorio.findByDisponibilidadeTrue();
    }
}
