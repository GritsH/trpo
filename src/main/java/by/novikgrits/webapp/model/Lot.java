package by.novikgrits.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;
import java.util.Objects;

public class Lot implements Comparable<Lot> {
    @Id
    private Integer id;
    @Column("item_id")
    private Integer itemId;
    @Column("starting_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate startingDate;
    @Column("closing_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate closingDate;
    @Column("starting_price")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double startingPrice;
    @Column("step")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double step;
    @Column("current_price")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double currentPrice;
    @Column("category_id")
    private Integer categoryId;
    @Column("status_id")
    private Integer statusId;

    public Lot(Integer itemId, LocalDate startingDate,
               LocalDate closingDate, Double startingPrice,
               Double step, Integer categoryId, Integer statusId) {
        this.itemId = itemId;
        this.startingDate = startingDate;
        this.closingDate = closingDate;
        this.startingPrice = startingPrice;
        this.step = step;
        this.categoryId = categoryId;
        this.statusId = statusId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lot lot = (Lot) o;
        return Objects.equals(id, lot.id) && Objects.equals(itemId, lot.itemId) && Objects.equals(startingDate, lot.startingDate) && Objects.equals(closingDate, lot.closingDate) && Objects.equals(startingPrice, lot.startingPrice) && Objects.equals(step, lot.step) && Objects.equals(categoryId, lot.categoryId) && Objects.equals(statusId, lot.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemId, startingDate, closingDate, startingPrice, step, categoryId, statusId);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", startingDate=" + startingDate +
                ", closingDate=" + closingDate +
                ", startingPrice=" + startingPrice +
                ", step=" + step +
                ", categoryId=" + categoryId +
                ", statusId=" + statusId +
                '}';
    }

    @Override
    public int compareTo(Lot lot) {
        return getCurrentPrice().compareTo(lot.getCurrentPrice());
    }
}
