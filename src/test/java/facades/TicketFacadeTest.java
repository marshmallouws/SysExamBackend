/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.User;
import errorhandling.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author Annika
 */
//@Disabled
public class TicketFacadeTest {

    private static EntityManagerFactory emf;
    private static TicketFacade facade;

    public TicketFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = TicketFacade.getTicketFacade(emf);
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
    public void testAddTicket() {
        int size = facade.getTickets("admin").size();
        try {
            facade.sellTicket("admin", 2299);
        } catch (NotFoundException e) {
            fail();
        }
        
        assertEquals(facade.getTickets("admin").size(), size);
        assertNotNull(facade.getTicket("admin", 2299));
    }

    @Test
    public void testAddTicketWithUnknownSeriesId() {
        boolean expectError = false;
        try {
            facade.sellTicket("admin", 0);
        } catch (NotFoundException e) {
            expectError = true;
        }
        assertEquals(expectError, true);
    }

    // Instead of inserting a new row, the system should increase
    // amount when a user buys a new ticket to an event they already
    // have tickets for
    @Test
    public void testAddTicketIncreaseAmount() {
        int amount = facade.getTicket("admin", 2299).getAmount();
        try {
            facade.sellTicket("admin", 2299); //sells one ticket at a time
        } catch (NotFoundException e) {
            fail();
        }
        
        assertEquals(amount + 1, facade.getTicket("admin", 2299).getAmount());
    }
}
