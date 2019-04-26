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

    public void setId(long id){
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate){
        this.birthdate=birthdate;
    }
}

    /*{"id":1,"name":"Large","birthdate":"\/Date(1334514600000)\/"}

        */
