package by.novikgrits.webapp.model;

import java.util.Date;
import java.util.Objects;

public class Car {
    private Integer id;
    private Integer lotId;
    private String brand;
    private Date manufactureYear;
    private Integer mileage;
    private Integer engineVolume;

    public Car(Integer lotId, String brand, Date manufactureYear, Integer mileage, Integer engineVolume) {
        this.lotId = lotId;
        this.brand = brand;
        this.manufactureYear = manufactureYear;
        this.mileage = mileage;
        this.engineVolume = engineVolume;
    }

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getLotId() {
        return lotId;
    }

    public String getBrand() {
        return brand;
    }

    public Date getManufactureYear() {
        return manufactureYear;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Integer getEngineVolume() {
        return engineVolume;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setManufactureYear(Date manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setEngineVolume(Integer engineVolume) {
        this.engineVolume = engineVolume;
    }

    public void setId(Integer id) {
        this.id = id;
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
