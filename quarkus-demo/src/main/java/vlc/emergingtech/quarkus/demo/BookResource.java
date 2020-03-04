package vlc.emergingtech.quarkus.demo;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * BookResource
 */
@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @POST
    @Transactional
    public Book createBook(Book book) {
        book.persist();
        return book;
    }
    
    @GET
    public List<Book> list() {
        return Book.listAll();
    }

    @GET
    @Path("query")
    public List<Book> findByName(@QueryParam("name")String name) {
        return Book.find("name = ?1", name).list();
    }

    @Inject
    BookRepository repo;

    @Transactional
    @DELETE
    @Path("{id}")
    public Book delete(@PathParam("id") Long id) {
        Book book = Book.findById(id);
        if (book == null) {
            throw new NotFoundException();
        }
        repo.delete(book);
        return book;
    }
}