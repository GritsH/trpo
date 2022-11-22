package by.novikgrits.webapp.model.item;

import java.util.Objects;

public class SportEquipment extends Item {
    private Integer lotId;
    private Float weight;
    private String brand;

    public Integer getLotId() {
        return lotId;
    }

    public Float getWeight() {
        return weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportEquipment that = (SportEquipment) o;
        return Objects.equals(id, that.id) && Objects.equals(lotId, that.lotId) && Objects.equals(weight, that.weight) && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId, weight, brand);
    }

    @Override
    public String toString() {
        return "SportEquipment{" +
                "id=" + id +
                ", lotId=" + lotId +
                ", weight=" + weight +
                ", brand='" + brand + '\'' +
                '}';
    }
}
