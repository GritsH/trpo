package by.novikgrits.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

public class BidHistory implements Comparable<BidHistory> {
    private Integer id;
    private Integer bidderId;
    private Integer lotId;
    private Double price;
    private LocalDate biddingDate;

    public BidHistory(Integer bidderId, Integer lotId, Double price, LocalDate biddingDate) {
        this.bidderId = bidderId;
        this.lotId = lotId;
        this.price = price;
        this.biddingDate = biddingDate;
    }

    public BidHistory() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getBidderId() {
        return bidderId;
    }

    public Integer getLotId() {
        return lotId;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getBiddingDate() {
        return biddingDate;
    }


    @Override
    public int compareTo(BidHistory history) {
        return getBiddingDate().compareTo(history.getBiddingDate());
    }
}
