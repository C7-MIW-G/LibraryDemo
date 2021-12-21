package nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.controller;

import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.model.Author;
import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Maak en beheer schrijvers
 */

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    protected String showAuthorOverview(Model model) {
        model.addAttribute("allAuthors", authorRepository.findAll());
        model.addAttribute("newAuthor", new Author());
        return "authorOverview";
    }

    @PostMapping("/authors/new")
    protected String saveOrUpdateAuthor(@ModelAttribute("newAuthor") Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "authorOverview";
        }
        authorRepository.save(author);
        return "redirect:/authors";
    }
}
