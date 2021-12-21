package nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Een exemplaar van een boek, die je daadwerkelijk op de plank kunt zetten/lenen
 */

@Entity
@Getter @Setter
public class Copy {

    @Id
    @GeneratedValue
    private Long copyId;

    @ManyToOne
    private Book book;

    private boolean available = true;

}
