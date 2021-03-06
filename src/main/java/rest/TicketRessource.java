package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.TicketDTO;
import errorhandling.NotFoundException;
import facades.TicketFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public Response buyTicket(String content) throws IOException, NotFoundException {
        JsonArray json = new JsonParser().parse(content).getAsJsonArray();
        System.out.println(json);
        List<TicketDTO> tickets = new ArrayList();
        json.forEach(element -> {
            try {
                JsonObject j = (JsonObject) element;
                String username = j.get("username").getAsString();
                int sId = j.get("sId").getAsInt();
                double price;
                String pTxt = j.get("type").getAsString();
                if (pTxt.equals("flight")) {
                    price = j.get("price").getAsDouble();
                } else {
                    price = 500;
                }

                tickets.add(FACADE.sellTicket(username, sId, price));
            } catch (NotFoundException ex) {
                Logger.getLogger(TicketRessource.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return Response.ok(tickets).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all/{username}")
    public Response getTickets(@PathParam("username") String username) {
        return Response.ok(FACADE.getTickets(username)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}/{seriesId}")
    public Response getTicket(@PathParam("username") String username, @PathParam("seriesId") int seriesId) {
        return Response.ok(FACADE.getTicket(username, seriesId)).build();
    }
}
