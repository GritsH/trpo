package by.novikgrits.webapp.model.item;

import java.util.Objects;

public class OtherItem extends Item {
    private Integer lotId;

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OtherItem otherItem = (OtherItem) o;
        return Objects.equals(id, otherItem.id) && Objects.equals(lotId, otherItem.lotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId);
    }

    @Override
    public String toString() {
        return "OtherItem{" +
                "id=" + id +
                ", lotId=" + lotId +
                '}';
    }
}
