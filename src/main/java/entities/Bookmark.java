package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bookmarks")
public class Bookmark implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bookmark_content")
    private String bookmarkContent; // just test content
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookmark_id")
    private User user;

    public Bookmark() {
    }
    
    public Bookmark(String bookmarkContent) {
        this.bookmarkContent = bookmarkContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookmarkContent() {
        return bookmarkContent;
    }

    public void setBookmarkContent(String bookmarkContent) {
        this.bookmarkContent = bookmarkContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bookmark{" + "bookmarkContent=" + bookmarkContent + '}';
    }
    
    
}
