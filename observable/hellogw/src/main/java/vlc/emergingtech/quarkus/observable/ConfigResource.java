package vlc.emergingtech.quarkus.observable;


import java.util.NoSuchElementException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;


@Path("/config")
public class ConfigResource {


  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getConfiguration() {
      Config config = ConfigProvider.getConfig();
      StringBuilder sb = new StringBuilder();
      for (String property : config.getPropertyNames()) {
        sb.append(property).append("=");
        try {
          sb.append(config.getOptionalValue(property, String.class).orElse("can't get value"));
        } catch (NoSuchElementException e) {
          sb.append(e.getMessage());
        }
        sb.append("\n");
      }
      return sb.toString();
  }
}