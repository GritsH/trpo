package by.novikgrits.webapp.repository.item;

import by.novikgrits.webapp.mapper.FurnitureRowMapper;
import by.novikgrits.webapp.model.item.Furniture;
import by.novikgrits.webapp.model.item.Item;
import by.novikgrits.webapp.model.item.ItemType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FurnitureRepository implements ItemRepository {
    private static final String INSERT = "insert into furniture (lot_id, furniture_type_id, material) values (?,?,?)";
    private static final String SELECT_BY_LOT_ID = "select * from furniture where lot_id = ?";
    private static final String SELECT_ALL = "select * from furniture";
    private static final String DELETE_BY_LOT_ID = "delete from furniture where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public FurnitureRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Item item) {
        Furniture furniture = (Furniture) item;
        jdbcTemplate.update(INSERT,
                furniture.getLotId(), furniture.getFurnitureTypeId(), furniture.getMaterial());
    }

    @Override
    public Optional<Item> findByLotId(Integer lotId) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID, new Object[]{lotId}, new FurnitureRowMapper()));
    }

    public List<Furniture> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new FurnitureRowMapper());
    }

    @Override
    public void deleteByLotId(Integer lotId) {
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }

    @Override
    public ItemType getType() {
        return ItemType.FURNITURE;
    }
}
