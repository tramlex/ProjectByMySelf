package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "AUTO", schema = "PUBLIC", catalog = "TEST")
public class AutoEntity {
    private long id;
    private String model;
    private int horsepower;
    private long ownerId;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MODEL", nullable = false, length = 64)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "HORSEPOWER", nullable = false)
    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoEntity that = (AutoEntity) o;

        if (id != that.id) return false;
        if (horsepower != that.horsepower) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + horsepower;
        return result;
    }

    @Basic
    @Column(name = "ownerId", nullable = false)
    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

}
