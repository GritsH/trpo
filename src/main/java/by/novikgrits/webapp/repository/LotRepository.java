package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.LotRowMapper;
import by.novikgrits.webapp.model.Lot;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class LotRepository {
    public static final String INSERT = "insert into lot (starting_date, closing_date, starting_price, step, " +
            "current_price, brief_info, owner_id, lot_name, status_id, item_type) values (?,?,?,?,?,?,?,?,?,?)";
    public static final String DELETE = "delete from lot where id = ?";
    public static final String SELECT_BY_ID = "select * from lot where id = ?";
    public static final String SELECT_BY_OWNER_ID = "select * from lot where owner_id = ?";
    public static final String SELECT_ALL = "select * from lot";
    public static final String SELECT_ALL_ACTIVE = "select * from lot where status_id = 1";
    public static final String SELECT_ALL_CLOSED = "select * from lot where status_id = 2";
    public static final String SELECT_ALL_SOLD = "select * from lot where status_id = 3";
    public static final String UPDATE = "update lot set starting_date = ?, closing_date = ?, " +
            "starting_price = ?, step = ?, current_price = ?, " +
            "brief_info = ?, " +
            "owner_id = ?, lot_name = ?, status_id = ? where id = ?";

    public static final String SELECT_ALL_BY_TYPE_AND_STATUS = "select * from lot where item_type = ? and status_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public LotRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Lot lot, GeneratedKeyHolder keyHolder) {
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, Date.valueOf(lot.getStartingDate()));
            preparedStatement.setDate(2, Date.valueOf(lot.getClosingDate()));
            preparedStatement.setDouble(3, lot.getStartingPrice());
            preparedStatement.setDouble(4, lot.getStep());
            preparedStatement.setDouble(5, lot.getStartingPrice());
            preparedStatement.setString(6, lot.getBriefInfo());
            preparedStatement.setInt(7, lot.getOwnerId());
            preparedStatement.setString(8, lot.getLotName());
            preparedStatement.setInt(9, lot.getStatusId());
            preparedStatement.setString(10, lot.getItemType().getTypeDescription());

            return preparedStatement;
        }, keyHolder);
    }

    public void deleteById(Integer id) {
        jdbcTemplate.update(DELETE, id);
    }

    public Optional<Lot> findById(Integer id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id}, new LotRowMapper()));
    }

    public List<Lot> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new LotRowMapper());
    }

    public List<Lot> findAllByOwnerId(Integer ownerId) {
        return jdbcTemplate.query(SELECT_BY_OWNER_ID, new Object[]{ownerId}, new LotRowMapper());
    }


    public List<Lot> findAllActive() {
        return jdbcTemplate.query(SELECT_ALL_ACTIVE, new LotRowMapper());
    }

    public List<Lot> findAllClosed() {
        return jdbcTemplate.query(SELECT_ALL_CLOSED, new LotRowMapper());
    }

    public List<Lot> findAllSold() {
        return jdbcTemplate.query(SELECT_ALL_SOLD, new LotRowMapper());
    }

    public void update(Lot lot) {
        jdbcTemplate.update(UPDATE,
                lot.getStartingDate(), lot.getClosingDate(), lot.getStartingPrice(),
                lot.getStep(), lot.getCurrentPrice(),
                lot.getBriefInfo(), lot.getOwnerId(), lot.getLotName(),
                lot.getStatusId(), lot.getId());
    }

    public List<Lot> findLotsByTypeAndStatus(String itemType, Integer statusId) {
        return jdbcTemplate.query(SELECT_ALL_BY_TYPE_AND_STATUS, new Object[]{itemType, statusId}, new LotRowMapper());
    }

}
