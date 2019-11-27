package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.TicketDTO;
import facades.PandaFacade;
import facades.TicketFacade;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

@Path("tickets")
public class TicketRessource {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final TicketFacade FACADE = TicketFacade.getTicketFacade(EMF);

    @Context
    SecurityContext securityContext;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/buy")
    public Response buyTicket(String content) throws IOException {
        JsonObject json = new JsonParser().parse(content).getAsJsonObject();
        String username = json.get("username").getAsString();
        int sId = json.get("series_id").getAsInt();
        TicketDTO ticket = FACADE.sellTicket(username, sId);
        return Response.ok(ticket).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all/{username}")
    public Response getTickets(@PathParam("username") String username) {
        return Response.ok(FACADE.getTickets(username)).build();
    }
    /*
    
    @POST
    @Produces(MediaType.)
    
    
    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getSingle(@PathParam("id") int id) throws IOException {
        return GSON.toJson(FACADE.getSingleSerie(id));
    } */
}