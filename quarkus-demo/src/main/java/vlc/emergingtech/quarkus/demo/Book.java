package vlc.emergingtech.quarkus.demo;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Book
 */
@Entity
public class Book extends PanacheEntity{

    public String name;
    public String author;
    
}