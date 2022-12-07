package by.novikgrits.webapp.model;

import java.time.LocalDate;

public class BidHistory implements Comparable<BidHistory> {
    private Integer id;
    private Integer lotId;
    private String bidderEmail;
    private Double price;
    private LocalDate biddingDate;

    public BidHistory() {
    }

    public BidHistory(Integer lotId, String bidderEmail, Double price, LocalDate biddingDate) {
        this.lotId = lotId;
        this.bidderEmail = bidderEmail;
        this.price = price;
        this.biddingDate = biddingDate;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLotId() {
        return lotId;
    }

    public String getBidderEmail() {
        return bidderEmail;
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

    public void setBidderEmail(String bidderEmail) {
        this.bidderEmail = bidderEmail;
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
