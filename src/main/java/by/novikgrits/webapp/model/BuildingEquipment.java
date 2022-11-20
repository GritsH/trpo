package by.novikgrits.webapp.model;

import java.util.Objects;

public class BuildingEquipment {
    private Integer id;
    private Integer lotId;
    private String brand;

    public BuildingEquipment() {
    }

    public BuildingEquipment(Integer lotId, String brand) {
        this.lotId = lotId;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
