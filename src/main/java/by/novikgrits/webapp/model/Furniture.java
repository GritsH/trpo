package by.novikgrits.webapp.model;

import java.util.Objects;

public class Furniture {
    private Integer id;
    private Integer lotId;
    private Integer furnitureTypeId;
    private String material;

    public Furniture(Integer lotId, Integer furnitureTypeId, String material) {
        this.lotId = lotId;
        this.furnitureTypeId = furnitureTypeId;
        this.material = material;
    }

    public Furniture() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getLotId() {
        return lotId;
    }

    public Integer getFurnitureTypeId() {
        return furnitureTypeId;
    }

    public String getMaterial() {
        return material;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setFurnitureTypeId(Integer furnitureTypeId) {
        this.furnitureTypeId = furnitureTypeId;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return Objects.equals(id, furniture.id) && Objects.equals(lotId, furniture.lotId) && Objects.equals(furnitureTypeId, furniture.furnitureTypeId) && Objects.equals(material, furniture.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId, furnitureTypeId, material);
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "id=" + id +
                ", lotId=" + lotId +
                ", furnitureTypeId=" + furnitureTypeId +
                ", material='" + material + '\'' +
                '}';
    }
}
