package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.RealEstateRowMapper;
import by.novikgrits.webapp.model.RealEstate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RealEstateRepository {
    private static final String INSERT = "insert into real_estate (lot_id, room_amount, living_space) values (?,?,?)";
    private static final String SELECT_BY_LOT_ID = "select * from real_estate where lot_id = ?";
    private static final String SELECT_ALL = "select * from real_estate";
    private static final String DELETE_BY_ID = "delete from real_estate where id = ?";
    private static final String DELETE_BY_LOT_ID = "delete from real_estate where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public RealEstateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(RealEstate realEstate) {
        jdbcTemplate.update(INSERT, realEstate.getLotId(), realEstate.getRoomAmount(), realEstate.getLivingSpace());
    }

    public Optional<RealEstate> findByLotId(Integer lotId) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID, new Object[]{lotId}, new RealEstateRowMapper()));
    }

    public List<RealEstate> findAll() {
        List<RealEstate> all = jdbcTemplate.query(SELECT_ALL, new RealEstateRowMapper());
        return all;
    }

    public void deleteById(Integer realEstateId) {
        jdbcTemplate.update(DELETE_BY_ID, realEstateId);
    }

    public void deleteByLotId(Integer lotId) {
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }
}
