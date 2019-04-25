package model;

import javax.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String publisher;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "webpageId")
    private Webpage webpage;


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Webpage getWebpage() {
        return webpage;
    }

    public void setWebpage(Webpage webpage) {
        this.webpage = webpage;
    }
}
