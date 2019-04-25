package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {
    @Id
    private long id;
    private String title;
    private String gender;


    public Game(String title, String gender) {
        this.title = title;
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
