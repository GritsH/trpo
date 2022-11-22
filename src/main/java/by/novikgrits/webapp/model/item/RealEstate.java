package by.novikgrits.webapp.model.item;

import java.util.Objects;

public class RealEstate extends Item {
    private Integer lotId;
    private Integer roomAmount;
    private Integer livingSpace;

    public Integer getLotId() {
        return lotId;
    }

    public Integer getRoomAmount() {
        return roomAmount;
    }

    public Integer getLivingSpace() {
        return livingSpace;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setRoomAmount(Integer roomAmount) {
        this.roomAmount = roomAmount;
    }

    public void setLivingSpace(Integer livingSpace) {
        this.livingSpace = livingSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealEstate that = (RealEstate) o;
        return Objects.equals(id, that.id) && Objects.equals(lotId, that.lotId) && Objects.equals(roomAmount, that.roomAmount) && Objects.equals(livingSpace, that.livingSpace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId, roomAmount, livingSpace);
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "id=" + id +
                ", lotId=" + lotId +
                ", roomAmount=" + roomAmount +
                ", livingSpace=" + livingSpace +
                '}';
    }
}
