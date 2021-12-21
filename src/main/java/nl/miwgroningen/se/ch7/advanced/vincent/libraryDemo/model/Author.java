package nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Schrijvers van boeken
 */

@Entity
@Getter @Setter
public class Author {

    @Id
    @GeneratedValue
    private Long authorId;

    private String firstName;
    private String infixName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    Set<Book> booksWritten = new HashSet<>();

    public String getDisplayName() {
        return String.format("%s %s, %s", infixName, lastName, firstName);
    }

}
