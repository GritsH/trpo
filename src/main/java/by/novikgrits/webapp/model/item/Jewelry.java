package by.novikgrits.webapp.model.item;

import java.util.Objects;

public class Jewelry extends Item {
    private Integer lotId;
    private String material;
    private Boolean hasPreciousStones;

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
