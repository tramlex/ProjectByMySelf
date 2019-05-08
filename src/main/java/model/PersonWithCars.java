package model;

import java.lang.reflect.Array;
import java.util.Date;

public class PersonWithCars {

    private Long id;
    private String name;
    private Date birthdate;
    private String[] cars;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String[] getCars() {
        return cars;
    }

    public void setCars(String[] cars) {
        this.cars = cars;
    }
}
