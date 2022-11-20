package by.novikgrits.webapp.model;

import by.novikgrits.webapp.repository.SportEquipmentRepository;

public class Auction {
    private Lot lot;
    private Car car;
    private RealEstate realEstate;
    private Jewelry jewelry;
    private Furniture furniture;
    private Clothes clothes;
    private BuildingEquipment buildingEquipment;
    private SportEquipment sportEquipment;
    private MedicalEquipment medicalEquipment;
    private OtherItem otherItem;

    public Auction(Lot lot, Car car, RealEstate realEstate, Jewelry jewelry) {
        this.lot = lot;
        this.car = car;
        this.realEstate = realEstate;
        this.jewelry = jewelry;
    }

    public Auction() {
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public BuildingEquipment getBuildingEquipment() {
        return buildingEquipment;
    }

    public void setBuildingEquipment(BuildingEquipment buildingEquipment) {
        this.buildingEquipment = buildingEquipment;
    }

    public SportEquipment getSportEquipment() {
        return sportEquipment;
    }

    public void setSportEquipment(SportEquipment sportEquipment) {
        this.sportEquipment = sportEquipment;
    }

    public MedicalEquipment getMedicalEquipment() {
        return medicalEquipment;
    }

    public void setMedicalEquipment(MedicalEquipment medicalEquipment) {
        this.medicalEquipment = medicalEquipment;
    }

    public OtherItem getOtherItem() {
        return otherItem;
    }

    public void setOtherItem(OtherItem otherItem) {
        this.otherItem = otherItem;
    }

    public Jewelry getJewelry() {
        return jewelry;
    }

    public void setJewelry(Jewelry jewelry) {
        this.jewelry = jewelry;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public RealEstate getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(RealEstate realEstate) {
        this.realEstate = realEstate;
    }
}
