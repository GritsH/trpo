package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.FurnitureRowMapper;
import by.novikgrits.webapp.model.Furniture;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FurnitureRepository {
    private static final String INSERT = "insert into furniture (lot_id, furniture_type_id, material) values (?,?,?)";
    private static final String SELECT_BY_LOT_ID = "select * from furniture where lot_id = ?";
    private static final String SELECT_ALL = "select * from furniture";
    private static final String DELETE_BY_LOT_ID = "delete from furniture where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public FurnitureRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Furniture furniture) {
        jdbcTemplate.update(INSERT,
                furniture.getLotId(), furniture.getFurnitureTypeId(), furniture.getMaterial());
    }

    public Optional<Furniture> findByLotId(Integer lotId) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID, new Object[]{lotId}, new FurnitureRowMapper()));
    }

    public List<Furniture> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new FurnitureRowMapper());
    }

    public void deleteByLotId(Integer lotId) {
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }
}
