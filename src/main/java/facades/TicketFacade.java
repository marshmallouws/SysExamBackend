/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.SeriesDTO;
import dtos.TicketDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import entities.Ticket;
import entities.User;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.persistence.RollbackException;
import utils.EMF_Creator;

/**
 *
 * @author Annika
 */
public class TicketFacade {
    private static TicketFacade instance;
    private static EntityManagerFactory emf;
    private PandaFacade p = PandaFacade.getPandaFacade();
    
    private TicketFacade() {}
    
    public static TicketFacade getTicketFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TicketFacade();
        }
        
        return instance;
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public TicketDTO sellTicket(String username, int seriesId) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, username);
        
        if(user == null) {
            return null;
        }
        
        try {
            p.getSingleSerie(seriesId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Ticket ticket = new Ticket(500.0, seriesId, user);
        
        try {
            em.getTransaction().begin();
            em.persist(ticket);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new TicketDTO(ticket);
    }
    
    public Ticket getTickets(String username) {
        return null;
    }
    
    public Ticket getTicket(String username, int seriesId) {
        return null;
    }
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        TicketFacade t = TicketFacade.getTicketFacade(emf);
        t.sellTicket("admin", 2299);
    }
    
    
    
}
