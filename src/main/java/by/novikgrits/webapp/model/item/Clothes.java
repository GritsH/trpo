package by.novikgrits.webapp.model.item;

import java.util.Objects;

public class Clothes extends Item {
    private Integer lotId;
    private String material;
    private String brand;
    private Integer size;

    public Integer getLotId() {
        return lotId;
    }

    public String getMaterial() {
        return material;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getSize() {
        return size;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return Objects.equals(id, clothes.id) && Objects.equals(lotId, clothes.lotId) && Objects.equals(material, clothes.material) && Objects.equals(brand, clothes.brand) && Objects.equals(size, clothes.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId, material, brand, size);
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id=" + id +
                ", lotId=" + lotId +
                ", material='" + material + '\'' +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                '}';
    }
}
