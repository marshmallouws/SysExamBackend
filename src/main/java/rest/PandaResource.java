package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BookmarkDTO;
import dtos.SeriesDTO;
import entities.Bookmark;
import entities.User;
import errorhandling.NotFoundException;
import facades.PandaFacade;
import facades.UserFacade;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
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

@Path("series")
public class PandaResource {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final PandaFacade FACADE = PandaFacade.getPandaFacade();
    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final UserFacade USERFACADE = UserFacade.getUserFacade(emf);

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/first15")
    public String getFromUser() throws IOException {
        SeriesDTO[] series = null;
        try {
            series = FACADE.getAllSeries();
        } catch (NotFoundException e) {
            
        }
        return GSON.toJson(series);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/bookmark")
    public Response addBookmark(String payload) {
        
        EntityManager em = emf.createEntityManager();
        String responseMessage = null;
        Gson gson = new Gson();

        try {

            BookmarkDTO bmdto = gson.fromJson(payload, BookmarkDTO.class);
            Bookmark existing = USERFACADE.getBookmark(bmdto.getUser_id(), bmdto.getEvent_id());

            if (existing.getBookmarkContent().equals("none")) {
                User bookmarkUser = USERFACADE.getUser(bmdto.getUser_id());
                
                if (bookmarkUser == null) {
                    responseMessage = "nouser";
                    return Response.status(Response.Status.OK).entity(responseMessage).build();
                }
                
                Bookmark bookmark = new Bookmark(bmdto.getEvent_id());

                em.getTransaction().begin();
                    bookmark.setUser(bookmarkUser);
                    em.persist(bookmark);
                em.getTransaction().commit();
                
                responseMessage = "true";
            } else {
                em.getTransaction().begin();
                    if (!em.contains(existing)) {
                        existing = em.merge(existing);
                    }
                    
                    em.remove(existing);
                em.getTransaction().commit();
                
                responseMessage = "false";
            }

            return Response.status(Response.Status.OK).entity(responseMessage).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }

    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userbookmarks/{userid}")
    public String getUserBookmarks(@PathParam("userid") String username) throws IOException {
        List<BookmarkDTO> foundBookmarks = USERFACADE.getUserBookmarks(username);
        String result = GSON.toJson(foundBookmarks);
        return result;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/single/{sId}")
    public Response getSingle(@PathParam("sId") int sId) {
        SeriesDTO s = null; 
        try {
            s = FACADE.getSingleSerie(sId);
        } catch (Exception e) {
            return Response.serverError().build();
        }
        
        return Response.ok(GSON.toJson(s)).build();
    }
}
