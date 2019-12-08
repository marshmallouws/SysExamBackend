/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.TicketDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import entities.Ticket;
import entities.User;
import errorhandling.NotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
    
    public TicketDTO sellTicket(String username, int seriesId, double price) throws NotFoundException {
        EntityManager em = getEntityManager();
        
        User user = em.find(User.class, username);
        
        if(user == null) {
            throw new NotFoundException("User not found: " + username);
        }
        
        p.getSingleSerie(seriesId);
        
        TypedQuery<Ticket> query = em.createQuery("SELECT t FROM Ticket t WHERE t.seriesId = :sId AND t.user.userName = :username", Ticket.class);
        query.setParameter("sId", seriesId);
        query.setParameter("username", username);
        Ticket ticket = null;
        
        try {
            ticket = query.getSingleResult();
            ticket.setAmount(ticket.getAmount() +1);
        } catch (NoResultException e) {
            ticket = new Ticket(price, seriesId, user, 1);
        } finally {
            try {
                em.getTransaction().begin();
                em.merge(ticket);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
        }
        return new TicketDTO(ticket);
    }
    
    public List<TicketDTO> getTickets(String username) {
        EntityManager em = getEntityManager();
        TypedQuery<Ticket> query = em.createQuery("SELECT t FROM Ticket t WHERE t.user.userName = :username", Ticket.class);
        query.setParameter("username", username);
        List<Ticket> tickets = query.getResultList();
        List<TicketDTO> res = new ArrayList<>();
        tickets.forEach(t -> {
            res.add(new TicketDTO(t));
        });
        
        return res;
    }
    
    public TicketDTO getTicket(String username, int seriesId) {
        EntityManager em = getEntityManager();
        TypedQuery<Ticket> query = em.createQuery("SELECT t FROM Ticket t WHERE t.user.userName = :username AND t.seriesId = :sId", Ticket.class);
        query.setParameter("sId", seriesId);
        query.setParameter("username", username);
        
        try {
            return new TicketDTO(query.getSingleResult());
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public static void main(String[] args) throws NotFoundException {
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        TicketFacade t = TicketFacade.getTicketFacade(emf);
        t.sellTicket("admin", 2299, 500);
        List<TicketDTO> l = t.getTickets("admin");
        l.forEach(li -> {
            System.out.println(li.getUsername() + li.getSeries_id() + " " + li.getAmount());
        });
        System.out.println(t.getTicket("admin", 2299));
        System.out.println(t.getTicket("admin", 2301));
    }
}
