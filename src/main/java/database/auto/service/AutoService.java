package database.auto.service;

public interface AutoService {
    public void saveAuto(String model, Integer horsepower, Long ownerId);
    public void clearAuto();
}
