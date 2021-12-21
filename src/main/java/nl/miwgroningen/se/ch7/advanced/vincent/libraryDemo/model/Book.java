package nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

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

    private String author;

    @OneToMany(mappedBy = "book")
    private List<Copy> copies;

    public int getNumberOfAvailableCopies() {
        int count = 0;
        for (Copy copy : copies) {
            count += copy.isAvailable() ? 1 : 0;
        }
        return count;
    }

}
