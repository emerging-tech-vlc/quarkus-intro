package vlc.emergingtech.quarkus.observable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v1")
@RegisterRestClient(configKey = "hello-api")
public interface GreetingService {

  @GET
  @Path("/hello")
  @Produces(MediaType.TEXT_PLAIN)
  public String hello();

}