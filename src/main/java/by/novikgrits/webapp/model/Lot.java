package by.novikgrits.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;
import java.util.Objects;

public class Lot implements Comparable<Lot> {
    private Integer id;
    private Integer ownerId;
    private LocalDate startingDate;
    private LocalDate closingDate;
    private Double startingPrice;
    private Double step;
    private Double currentPrice;
    private Integer locationId;
    private Integer statusId;
    private String briefInfo;

    public Lot(Integer ownerId, LocalDate startingDate, LocalDate closingDate, Double startingPrice,
               Double step, Double currentPrice, Integer locationId, Integer statusId, String briefInfo) {
        this.ownerId = ownerId;
        this.startingDate = startingDate;
        this.closingDate = closingDate;
        this.startingPrice = startingPrice;
        this.step = step;
        this.currentPrice = currentPrice;
        this.locationId = locationId;
        this.statusId = statusId;
        this.briefInfo = briefInfo;
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

    public Integer getLocationId() {
        return locationId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    @Override
    public int compareTo(Lot lot) {
        return getCurrentPrice().compareTo(lot.getCurrentPrice());
    }
}
