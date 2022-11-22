package by.novikgrits.webapp.model.item;

import java.util.Objects;

public class BuildingEquipment extends Item {
    private Integer lotId;
    private String brand;

    public Integer getLotId() {
        return lotId;
    }

    public String getBrand() {
        return brand;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildingEquipment that = (BuildingEquipment) o;
        return Objects.equals(id, that.id) && Objects.equals(lotId, that.lotId) && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId, brand);
    }

    @Override
    public String toString() {
        return "BuildingEquipment{" +
                "id=" + id +
                ", lotId=" + lotId +
                ", brand='" + brand + '\'' +
                '}';
    }
}
