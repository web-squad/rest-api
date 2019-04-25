package model;

import javax.persistence.Entity;

@Entity
public class Games {
    private String title;
    private String gender;


    public Games(String title, String gender) {
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
}
