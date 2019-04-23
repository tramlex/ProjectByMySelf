package database.auto.dao;

public interface AutoDao {
    public void saveAuto(String model, Integer horsepower, Long ownerId);
}
