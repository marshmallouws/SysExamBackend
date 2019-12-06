package rest;

import dtos.TicketDTO;
import entities.Bookmark;
import entities.User;
import entities.Role;
import errorhandling.NotFoundException;
import facades.TicketFacade;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author Annika
 */
@Disabled
public class TicketRessourceTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    private static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;

    private static EntityManagerFactory emf;
    private static TicketFacade facade;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = TicketFacade.getTicketFacade(emf);
        httpServer = startServer();

        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        EMF_Creator.endREST_TestWithDB();
        httpServer.shutdown();
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        try {
            User user = new User("user", "test1");
            User user1 = new User("admin", "test2");

            em.getTransaction().begin();
            em.createQuery("delete from Bookmark").executeUpdate();
            em.createQuery("delete from Ticket").executeUpdate();
            em.createQuery("delete from User").executeUpdate();
            em.createQuery("delete from Role").executeUpdate();
            em.persist(user);
            em.persist(user1);
            em.getTransaction().commit();

            facade.sellTicket("admin", 2299);
            facade.sellTicket("user", 2299);
        } catch (NotFoundException e) {
        } finally {
            em.close();
        }
    }

    @Test
    public void serverIsRunning() {
        System.out.println("Testing is server UP");
        given().when().get("/info").then().statusCode(200);
    }

    @Test
    public void testBuyTicket() {
        TicketDTO ticket = new TicketDTO(2299, "user", 2);
        String json = ("{\"sId\": 2299, \"username\": \"user\"}");
        given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("/tickets/buy").then()
                .statusCode(200);
    }
}
