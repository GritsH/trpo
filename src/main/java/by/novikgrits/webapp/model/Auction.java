package by.novikgrits.webapp.model;

import by.novikgrits.webapp.model.item.*;

public class Auction {
    private Lot lot;
    private Item item;

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
}
