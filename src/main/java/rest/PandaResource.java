package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.PandaFacade;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("series")
public class PandaResource {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final PandaFacade FACADE = PandaFacade.getPandaFacade();

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/first15")
    public String getFromUser() throws IOException {
        return GSON.toJson(FACADE.getAllSeries(""));
    }
}
