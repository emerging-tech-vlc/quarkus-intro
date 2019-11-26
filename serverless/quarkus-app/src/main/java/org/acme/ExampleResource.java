package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/reverse")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String reverseWords(@QueryParam("text") String text) {
        return new StringBuilder(text).reverse().toString();
    }
}