package by.novikgrits.webapp.model;

import java.time.LocalDate;

public class BidHistory implements Comparable<BidHistory> {
    private Integer id;
    private Integer lotId;
    private Integer bidderId;

    private Double price;

    private LocalDate biddingDate;

    public BidHistory() {
    }

    public BidHistory(Integer lotId, Integer bidderId, Double price, LocalDate biddingDate) {
        this.lotId = lotId;
        this.bidderId = bidderId;
        this.price = price;
        this.biddingDate = biddingDate;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLotId() {
        return lotId;
    }

    public Integer getBidderId() {
        return bidderId;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getBiddingDate() {
        return biddingDate;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setBidderId(Integer bidderId) {
        this.bidderId = bidderId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBiddingDate(LocalDate biddingDate) {
        this.biddingDate = biddingDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(BidHistory history) {
        return getBiddingDate().compareTo(history.getBiddingDate());
    }
}
