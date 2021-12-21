package nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.controller;

import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.model.Book;
import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.repository.AuthorRepository;
import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Alle interacties van de gebruiker met bibliotheekboeken
 */

@Controller
public class BookController {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BookController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping({"/", "/books"})
    protected String showBookOverview(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());
        return "bookOverview";
    }

    @GetMapping("/book/new")
    protected String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("allAuthors", authorRepository.findAll());
        return "bookForm";
    }

    @PostMapping("/book/new")
    protected String saveOrUpdateBook(@ModelAttribute("book") Book book, BindingResult result) {
        if (!result.hasErrors()) {
            bookRepository.save(book);
        }

        return "redirect:/books";
    }

}
