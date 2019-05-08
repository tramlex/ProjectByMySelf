package model;

public class Statistics {

    private Long personcount;
    private Long carcount;
    private Long uniquevendorcount;

    public long getUniquevendorcount() {
        return uniquevendorcount;
    }

    public void setUniquevendorcount(long uniquevendorcount) {
        this.uniquevendorcount = uniquevendorcount;
    }

    public long getCarcount() {
        return carcount;
    }

    public void setCarcount(long carcount) {
        this.carcount = carcount;
    }

    public long getPersoncount() {
        return personcount;
    }

    public void setPersoncount(long personcount) {
        this.personcount = personcount;
    }
}
