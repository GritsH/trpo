package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.BidHistory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BidHistoryRowMapper implements RowMapper<BidHistory> {
    @Override
    public BidHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        BidHistory bidHistory = new BidHistory();

        bidHistory.setId(rs.getInt("id"));
        bidHistory.setBiddingDate(rs.getTimestamp("bidding_date").toString().replace("T", " "));
        bidHistory.setBidderEmail(rs.getString("bidder_email"));
        bidHistory.setLotId(rs.getInt("lot_id"));
        bidHistory.setPrice(rs.getDouble("price"));
        return bidHistory;
    }
}
