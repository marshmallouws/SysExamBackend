package rest;

import com.google.gson.Gson;
import dtos.FlightDTO;
import errorhandling.NotFoundException;
import facades.PandaFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Martin
 */
@Path("flight")
public class FlightResource {

    private static final PandaFacade FACADE = PandaFacade.getPandaFacade();
    
    @Context
    private UriInfo context;

    public FlightResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAvailableFlights(String payload) {
        Gson gson = new Gson();
        FlightDTO[] flights = null;
        FlightDTO fdto = gson.fromJson(payload, FlightDTO.class);
        
        /*System.out.println(fdto.getOutboundDate());
        System.out.println(fdto.getOriginPlace());
        System.out.println(fdto.getDestination());*/
        
        try {
            flights = FACADE.getFlight(fdto.getOutboundDate(), "economy", fdto.getOriginPlace(), fdto.getDestination(), "1");
        } catch(NotFoundException e) {
            e.printStackTrace();
        }
        
        String res = gson.toJson(flights);
        
        return res;
    }

}
