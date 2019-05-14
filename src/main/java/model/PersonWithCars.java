package model;

import database.entities.AutoEntity;

import java.util.List;

public class PersonWithCars {

    private Long id;
    private String name;
    private String birthdate;
    private List<AutoEntity> cars;

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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public List<AutoEntity> getCars() {
        return cars;
    }

    public void setCars(List<AutoEntity> cars) {
        this.cars = cars;
    }
}
