package nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.repository;

import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
}
