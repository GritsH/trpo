package by.novikgrits.webapp.model;

import java.util.Objects;

public class Jewelry {
    private Integer id;
    private Integer lotId;
    private String material;
    private Boolean hasPreciousStones;

    public Jewelry(Integer lotId, String material, Boolean hasPreciousStones) {
        this.lotId = lotId;
        this.material = material;
        this.hasPreciousStones = hasPreciousStones;
    }

    public Jewelry() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getLotId() {
        return lotId;
    }

    public String getMaterial() {
        return material;
    }

    public Boolean getHasPreciousStones() {
        return hasPreciousStones;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setHasPreciousStones(Boolean hasPreciousStones) {
        this.hasPreciousStones = hasPreciousStones;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jewelry jewelry = (Jewelry) o;
        return Objects.equals(id, jewelry.id) && Objects.equals(lotId, jewelry.lotId) && Objects.equals(material, jewelry.material) && Objects.equals(hasPreciousStones, jewelry.hasPreciousStones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId, material, hasPreciousStones);
    }

    @Override
    public String toString() {
        return "Jewelry{" +
                "id=" + id +
                ", lotId=" + lotId +
                ", material='" + material + '\'' +
                ", hasPreciousStones=" + hasPreciousStones +
                '}';
    }
}
