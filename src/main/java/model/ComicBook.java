package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comic_books")
public class ComicBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "issue_number", nullable = false)
    private String issueNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "publication_date", nullable = false)
    private Date publicationDate;

    @Column(name = "comicCondition", nullable = false)
    private String comicCondition;

    // Constructors, Getters, and Setters

    public ComicBook() {
    }

    public ComicBook(String title, String issueNumber, Date publicationDate, String comicCondition) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        this.comicCondition = comicCondition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getcomicCondition() {
        return comicCondition;
    }

    public void setcomicCondition(String comicCondition) {
        this.comicCondition = comicCondition;
    }
}
