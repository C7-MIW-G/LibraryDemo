package nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Dit is een boek die door de bibliotheek uitgeleend kan worden
 */

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private List<Copy> copies;

    public int getNumberOfAvailableCopies() {
        int count = 0;
        for (Copy copy : copies) {
            count += copy.isAvailable() ? 1 : 0;
        }
        return count;
    }

    public String getAuthorsDisplayString() {
        StringBuilder authorsString = new StringBuilder();

        for (Author author : authors) {
            authorsString.append(" ").append(author.getDisplayName());
        }

        return authorsString.toString();
    }

}
