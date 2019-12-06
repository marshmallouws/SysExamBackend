package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.TicketDTO;
import errorhandling.NotFoundException;
import facades.TicketFacade;
import facades.UserFacade;
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

@Path("user")
public class UserRessource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final UserFacade FACADE = UserFacade.getUserFacade(EMF);

    @Context
    SecurityContext securityContext;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/airport")
    public Response setFavAirport(String content) {
        JsonObject json = new JsonParser().parse(content).getAsJsonObject();
        String username = json.get("username").getAsString();
        String airport = json.get("airport").getAsString();
        
        try {
            return Response.ok(new Gson().toJson(FACADE.setFavAirport(airport, username))).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}