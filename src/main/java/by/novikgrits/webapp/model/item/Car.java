package by.novikgrits.webapp.model.item;

import java.util.Objects;

public class Car extends Item {
    private Integer lotId;
    private String brand;
    private Integer manufactureYear;
    private Integer mileage;
    private Double engineVolume;

    public Integer getLotId() {
        return lotId;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(lotId, car.lotId) && Objects.equals(brand, car.brand) && Objects.equals(manufactureYear, car.manufactureYear) && Objects.equals(mileage, car.mileage) && Objects.equals(engineVolume, car.engineVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId, brand, manufactureYear, mileage, engineVolume);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", lotId=" + lotId +
                ", brand='" + brand + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", mileage=" + mileage +
                ", engineVolume=" + engineVolume +
                '}';
    }
}
