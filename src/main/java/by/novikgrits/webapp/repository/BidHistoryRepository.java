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
    private static final String INSERT_CMD = "insert into bid_history (lot_id, price, bidding_date, bidder_email) values (?,?,?,?)";
    private static final String SELECT_ALL_BY_ID = "select * from bid_history where id = ?";
    private static final String SELECT_ALL = "select * from bid_history";
    private static final String SELECT_BY_LOT_ID = "select * from bid_history where lot_id = ?";
    private static final String SELECT_BY_LOT_ID_BIDDER_ID = "select * from bid_history where bidder_email = ? and lot_id = ?";
    private static final String SELECT_BY_BIDDER_ID = "select * from bid_history where bidder_email = ?";
    private static final String SELECT_BY_DATE = "select * from bid_history where bidding_date = ?";
    private static final String SELECT_LAST_HISTORIES = "select * from bid_history where id in (select max(id) from bid_history group by lot_id)";
    private static final String SELECT_LAST_HISTORIES_SORT_BY_PRICE = "select * from bid_history where id in (select max(id) from bid_history group by lot_id) order by price";
    private static final String SELECT_LAST_HISTORIES_SORT_BY_BIDDER = "select * from bid_history where id in (select max(id) from bid_history group by lot_id) order by bidder_email";
    private static final String DELETE_BY_LOT_ID = "delete from bid_history where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public BidHistoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(BidHistory bidHistory) {
        jdbcTemplate.update(INSERT_CMD, bidHistory.getLotId(), bidHistory.getPrice(), bidHistory.getBiddingDate(),
                bidHistory.getBidderEmail());
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

    public List<BidHistory> findAllByBidderIdAndLotId(String bidderEmail, Integer lotId) {
        return jdbcTemplate.query(SELECT_BY_LOT_ID_BIDDER_ID, new Object[]{bidderEmail, lotId}, new BidHistoryRowMapper());
    }

    public List<BidHistory> findAllByBidderId(String bidderEmail) {
        return jdbcTemplate.query(SELECT_BY_BIDDER_ID, new Object[]{bidderEmail}, new BidHistoryRowMapper());
    }

    public List<BidHistory> findAllByDate(Date biddingDate) {
        return jdbcTemplate.query(SELECT_BY_DATE, new Object[]{biddingDate}, new BidHistoryRowMapper());
    }

    public List<BidHistory> findLastBiddersInLots() {
        return jdbcTemplate.query(SELECT_LAST_HISTORIES, new BidHistoryRowMapper());
    }

    public List<BidHistory> findSortedByPrice() {
        return jdbcTemplate.query(SELECT_LAST_HISTORIES_SORT_BY_PRICE, new BidHistoryRowMapper());
    }

    public List<BidHistory> findSortedByBidderEmail() {
        return jdbcTemplate.query(SELECT_LAST_HISTORIES_SORT_BY_BIDDER, new BidHistoryRowMapper());
    }

    public void deleteByLotId(Integer lotId) {
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }

}
