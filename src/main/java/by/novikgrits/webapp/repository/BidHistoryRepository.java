package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.BidHistoryRowMapper;
import by.novikgrits.webapp.model.BidHistory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class BidHistoryRepository {
    private static final String INSERT_CMD = "insert into bid_history (bidder_id, lot_id, price, bidding_date) values (?,?,?,?)";
    private static final String SELECT_ALL_BY_ID = "select * from bid_history where id = ?";
    private static final String SELECT_ALL = "select * from bid_history";
    private static final String SELECT_BY_LOT_ID = "select * from bid_history where lot_id = ?";
    private static final String SELECT_BY_LOT_ID_BIDDER_ID = "select * from bid_history where bidder_id = ? and lot_id = ?";
    private static final String SELECT_BY_BIDDER_ID = "select * from bid_history where bidder_id = ?";
    private static final String SELECT_BY_DATE = "select * from bid_history where bidding_date = ?";
    private final JdbcTemplate jdbcTemplate;

    public BidHistoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(BidHistory bidHistory) {
        jdbcTemplate.update(INSERT_CMD, bidHistory.getBidderId(), bidHistory.getLotId(),
                bidHistory.getPrice(), bidHistory.getBiddingDate());
    }

    public Optional<BidHistory> findById(Integer historyId) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_ALL_BY_ID,
                new Object[]{historyId}, new BidHistoryRowMapper()));
    }

    public List<BidHistory> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new BidHistoryRowMapper());
    }

    public List<BidHistory> findAllByLotId(Integer lotId) {
        return jdbcTemplate.query(SELECT_BY_LOT_ID, new Object[]{lotId}, new BidHistoryRowMapper());
    }

    public List<BidHistory> findAllByBidderIdAndLotId(Integer bidderId, Integer lotId) {
        return jdbcTemplate.query(SELECT_BY_LOT_ID_BIDDER_ID, new Object[]{bidderId, lotId}, new BidHistoryRowMapper());
    }

    public List<BidHistory> findAllByBidderId(Integer bidderId) {
        return jdbcTemplate.query(SELECT_BY_BIDDER_ID, new Object[]{bidderId}, new BidHistoryRowMapper());
    }

    public List<BidHistory> findAllByDate(Date biddingDate) {
        return jdbcTemplate.query(SELECT_BY_DATE, new Object[]{biddingDate}, new BidHistoryRowMapper());
    }

}
