package nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.controller;

import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.model.Book;
import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.model.Copy;
import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.repository.BookRepository;
import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.repository.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Maak en leen exemplaren van boeken
 */

@Controller
public class CopyController {

    private BookRepository bookRepository;
    private CopyRepository copyRepository;

    public CopyController(BookRepository bookRepository, CopyRepository copyRepository) {
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
    }

    @GetMapping("/copy/new/{bookId}")
    protected String createNewCopy(@PathVariable("bookId") Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isEmpty()) {
            return "redirect:/";
        }
        Copy newCopy = new Copy();
        newCopy.setBook(book.get());
        copyRepository.save(newCopy);
        return "redirect:/";
    }
}
