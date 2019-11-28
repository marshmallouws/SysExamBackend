/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Ticket;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author Annika
 */
public class TicketFacadeTest {
    
    private static EntityManagerFactory emf;
    private static TicketFacade facade;
    
    public TicketFacadeTest() {}
    
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
            
            Ticket t = new Ticket(500.0, 2299, user, 2);
            Ticket t1 = new Ticket(500.0, 2299, user1, 4);
            
            em.getTransaction().begin();
            em.persist(t);
            em.persist(t1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
            
    }
    
    @Test
    public void testAmountOfTickets() {
    }
    
    @Test
    public void testAddTicket() {
        
    }
    
    @Test
    public void testAddTicketWithUnknownSeriesId() {
        
    }
    
    // Instead of inserting a new row, the system should increase
    // amount when a user buys a new ticket to an event they already
    // have tickets for
    @Test
    public void testAddTicketIncreaseAmount() {
        
    }
    
    
    
}
