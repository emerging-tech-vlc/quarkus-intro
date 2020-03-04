package vlc.emergingtech.quarkus.demo;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * ReverseWordsResource
 */
@Path("reverse")
public class ReverseWordsResource {

    @POST
    public ApiResource reverse(ApiResource body) {
        ApiResource res = new ApiResource();
        res.text = new StringBuilder(body.text).reverse().toString();
        return res;
    }

}