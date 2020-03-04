package vlc.emergingtech.quarkus.demo;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Book
 */
@Entity
public class Book extends PanacheEntity{

    @NotNull
    @Size(min = 4)
    public String name;
    public String author;
    public String isbn;
    
}