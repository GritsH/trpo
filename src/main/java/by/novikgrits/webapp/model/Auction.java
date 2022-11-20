package by.novikgrits.webapp.model;

public class Auction {
    private Lot lot;
    private Car car;
    private RealEstate realEstate;
    private Jewelry jewelry;

    public Auction(Lot lot, Car car, RealEstate realEstate, Jewelry jewelry) {
        this.lot = lot;
        this.car = car;
        this.realEstate = realEstate;
        this.jewelry = jewelry;
    }

    public Auction() {
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
