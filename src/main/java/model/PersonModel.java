package model;

import java.util.Date;

public class PersonModel {

    private Long id;
    private String name;
    private Date birthdate;

    public PersonModel(long id, String name, Date birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }
}
