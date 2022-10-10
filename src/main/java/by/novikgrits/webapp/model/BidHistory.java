package by.novikgrits.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;
import java.util.Objects;

public class BidHistory implements Comparable<BidHistory> {
    @Id
    private Integer id;
    @Column("bidder_email")
    private String bidderEmail;
    @Column("lot_id")
    private Integer lotId;
    @Column("price")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double price;
    @Column("bidding_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate biddingDate;

    public BidHistory(String bidderEmail, Integer lotId, Double price, LocalDate biddingDate) {
        this.bidderEmail = bidderEmail;
        this.lotId = lotId;
        this.price = price;
        this.biddingDate = biddingDate;
    }

    public Integer getId() {
        return id;
    }

    public String getBidderEmail() {
        return bidderEmail;
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

    public void setBidderEmail(String bidderEmail) {
        this.bidderEmail = bidderEmail;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBiddingDate(LocalDate biddingDate) {
        this.biddingDate = biddingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BidHistory that = (BidHistory) o;
        return Objects.equals(id, that.id) && Objects.equals(bidderEmail, that.bidderEmail) && Objects.equals(lotId, that.lotId) && Objects.equals(price, that.price) && Objects.equals(biddingDate, that.biddingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bidderEmail, lotId, price, biddingDate);
    }

    @Override
    public String toString() {
        return "BidHistory{" +
                "id=" + id +
                ", bidderEmail='" + bidderEmail + '\'' +
                ", lotId=" + lotId +
                ", price=" + price +
                ", biddingDate=" + biddingDate +
                '}';
    }

    @Override
    public int compareTo(BidHistory history) {
        return getBiddingDate().compareTo(history.getBiddingDate());
    }
}
