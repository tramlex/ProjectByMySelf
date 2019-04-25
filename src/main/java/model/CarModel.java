package model;


public class CarModel {

    private Long id;
    private String model;
    private Integer horsepower;
    private Long ownerId;

    public CarModel(long id, String model, Integer horsepower, long ownerId) {
        this.id = id;
        this.model = model;
        this.horsepower = horsepower;
        this.ownerId = ownerId;
    }

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public long getOwnerId() {
        return ownerId;
    }

}
