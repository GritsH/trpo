package by.novikgrits.webapp.model;

import by.novikgrits.webapp.model.item.Item;

public class Auction {
    private Lot lot;
    private Item item;

    private LotPhoto photo;

    public Auction() {
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LotPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(LotPhoto photo) {
        this.photo = photo;
    }
}
