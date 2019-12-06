package facades;

import dtos.BookmarkDTO;
import entities.Bookmark;
import entities.Role;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import errorhandling.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public User createUser(String username, String password, String airport) {
        User user;
        if (airport == "") {
            user = new User(username, password);
        } else {
            user = new User(username, password, airport);
        }
        EntityManager em = emf.createEntityManager();

        user.addRole(new Role("user"));
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return user;
    }

    public long getUserCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long numOfUsers = (long) em.createQuery("SELECT COUNT(u) FROM User u").getSingleResult();
            return numOfUsers;
        } finally {
            em.close();
        }
    }

    public User getUser(String username) {
        EntityManager em = emf.createEntityManager();
        User user = null;
        try {
            user = em.find(User.class, username);
        } finally {
            em.close();
        }

        return user;
    }

    public Bookmark getBookmark(String username, String content) {
        EntityManager em = emf.createEntityManager();
        Bookmark bm = null;
        try {
            bm = (Bookmark) em.createQuery("SELECT b FROM Bookmark b WHERE b.user.userName = '" + username + "' AND b.bookmarkContent = '" + content + "'", Bookmark.class).getSingleResult();
        } catch (NoResultException e) {
            bm = new Bookmark("none");
        } finally {
            em.close();
        }
        return bm;
    }

    public List<BookmarkDTO> getUserBookmarks(String username) {
        EntityManager em = emf.createEntityManager();
        List<Bookmark> foundBookmarks = null;
        List<BookmarkDTO> fbmdto = new ArrayList<>();

        try {
            foundBookmarks = em.createQuery("SELECT b FROM Bookmark b WHERE b.user.userName = '" + username + "'", Bookmark.class).getResultList();

            for (Bookmark b : foundBookmarks) {
                fbmdto.add(new BookmarkDTO(b.getUser().getUserName(), b.getBookmarkContent()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return fbmdto;
    }
    
    public String setFavAirport(String airport, String username) {
        EntityManager em = emf.createEntityManager();
        try {
            User user = em.find(User.class, username);
            if(user == null) {
                return null;
            }
            
            user.setAirport(airport);
            
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
        return airport;
    }

    /*
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        EntityManager em = emf.createEntityManager();
        UserFacade u = UserFacade.getUserFacade(emf);
        u.setFavAirport("Ap", "user");
        
    } */
}
