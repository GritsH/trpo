package by.novikgrits.webapp.model.item;

import java.util.Objects;

public class Furniture extends Item {
    private Integer lotId;
    private String material;
    private FurnitureType furnitureType;

    public Furniture() {
    }

    public FurnitureType getFurnitureType() {
        return furnitureType;
    }

    public void setFurnitureType(FurnitureType furnitureType) {
        this.furnitureType = furnitureType;
    }

    public Integer getLotId() {
        return lotId;
    }

    public String getMaterial() {
        return material;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return Objects.equals(lotId, furniture.lotId) && Objects.equals(material, furniture.material) && furnitureType == furniture.furnitureType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotId, material, furnitureType);
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "lotId=" + lotId +
                ", material='" + material + '\'' +
                ", furnitureType=" + furnitureType +
                '}';
    }
}
