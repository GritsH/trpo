package by.novikgrits.webapp.model;

import by.novikgrits.webapp.model.item.ItemType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

public class Lot implements Comparable<Lot> {
    private Integer id;
    private Integer ownerId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startingDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate closingDate;
    private Double startingPrice;
    private Double step;
    private Double currentPrice;
    private Integer statusId;
    private String briefInfo;
    private String lotName;

    private ItemType itemType;

    public Lot(Integer ownerId, LocalDate startingDate, LocalDate closingDate, Double startingPrice,
               Double step, Double currentPrice, Integer statusId, String briefInfo, String lotName, ItemType itemType) {
        this.ownerId = ownerId;
        this.startingDate = startingDate;
        this.closingDate = closingDate;
        this.startingPrice = startingPrice;
        this.step = step;
        this.currentPrice = currentPrice;
        this.statusId = statusId;
        this.briefInfo = briefInfo;
        this.lotName = lotName;
        this.itemType = itemType;
    }

    public Lot() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public Double getStartingPrice() {
        return startingPrice;
    }

    public Double getStep() {
        return step;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public String getLotName() {
        return lotName;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public void setStartingPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public void setStep(Double step) {
        this.step = step;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lot lot = (Lot) o;
        return Objects.equals(id, lot.id) && Objects.equals(ownerId, lot.ownerId)
                && Objects.equals(startingDate, lot.startingDate)
                && Objects.equals(closingDate, lot.closingDate)
                && Objects.equals(startingPrice, lot.startingPrice)
                && Objects.equals(step, lot.step)
                && Objects.equals(currentPrice, lot.currentPrice)
                && Objects.equals(statusId, lot.statusId)
                && Objects.equals(briefInfo, lot.briefInfo)
                && Objects.equals(lotName, lot.lotName)
                && itemType == lot.itemType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerId, startingDate, closingDate, startingPrice, step, currentPrice, statusId, briefInfo, lotName, itemType);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", startingDate=" + startingDate +
                ", closingDate=" + closingDate +
                ", startingPrice=" + startingPrice +
                ", step=" + step +
                ", currentPrice=" + currentPrice +
                ", statusId=" + statusId +
                ", briefInfo='" + briefInfo + '\'' +
                ", lotName='" + lotName + '\'' +
                ", itemType=" + itemType +
                '}';
    }

    @Override
    public int compareTo(Lot lot) {
        return getCurrentPrice().compareTo(lot.getCurrentPrice());
    }
}
