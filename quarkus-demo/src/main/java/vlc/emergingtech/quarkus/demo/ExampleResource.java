package vlc.emergingtech.quarkus.demo;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class ExampleResource {

    @Inject
    @ConfigProperty(name = "demo.hello-name", defaultValue = "Unknown")
    private String defaultName;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") Optional<String> name) {
        return "Hello " + name.orElse(defaultName);
    }
}