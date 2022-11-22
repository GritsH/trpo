package by.novikgrits.webapp.model.item;

import java.util.Date;
import java.util.Objects;

public class MedicalEquipment extends Item {
    private Integer lotId;
    private Integer specialityId;
    private Date manufactureYear;
    private String brand;

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    public Date getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Date manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalEquipment that = (MedicalEquipment) o;
        return Objects.equals(id, that.id) && Objects.equals(lotId, that.lotId) && Objects.equals(specialityId, that.specialityId) && Objects.equals(manufactureYear, that.manufactureYear) && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId, specialityId, manufactureYear, brand);
    }

    @Override
    public String toString() {
        return "MedicalEquipment{" +
                "id=" + id +
                ", lotId=" + lotId +
                ", specialityId=" + specialityId +
                ", manufactureYear=" + manufactureYear +
                ", brand='" + brand + '\'' +
                '}';
    }
}
