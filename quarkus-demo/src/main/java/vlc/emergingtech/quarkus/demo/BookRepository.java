package vlc.emergingtech.quarkus.demo;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * BookRepository
 */
@ApplicationScoped
public class BookRepository implements PanacheRepository<Book>{

    
}