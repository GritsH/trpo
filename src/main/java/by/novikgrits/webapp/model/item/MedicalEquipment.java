package by.novikgrits.webapp.model.item;

import java.util.Date;
import java.util.Objects;

public class MedicalEquipment extends Item {
    private Integer lotId;
    private Integer manufactureYear;
    private String brand;
    private MedicalSpeciality medicalSpeciality;

    public MedicalSpeciality getMedicalSpeciality() {
        return medicalSpeciality;
    }

    public void setMedicalSpeciality(MedicalSpeciality medicalSpeciality) {
        this.medicalSpeciality = medicalSpeciality;
    }

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
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
        return Objects.equals(lotId, that.lotId) && Objects.equals(manufactureYear, that.manufactureYear) && Objects.equals(brand, that.brand) && medicalSpeciality == that.medicalSpeciality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotId, manufactureYear, brand, medicalSpeciality);
    }

    @Override
    public String toString() {
        return "MedicalEquipment{" +
                "lotId=" + lotId +
                ", manufactureYear=" + manufactureYear +
                ", brand='" + brand + '\'' +
                ", medicalSpeciality=" + medicalSpeciality +
                '}';
    }
}
