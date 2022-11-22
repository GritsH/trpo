package by.novikgrits.webapp.repository.item;

import by.novikgrits.webapp.mapper.OtherRowMapper;
import by.novikgrits.webapp.model.item.Item;
import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.model.item.OtherItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OtherItemRepository implements ItemRepository {
    private static final String INSERT = "insert into other (lot_id) values (?)";
    private static final String SELECT_BY_LOT_ID = "select * from other where lot_id = ?";
    private static final String SELECT_ALL = "select * from other";
    private static final String DELETE_BY_LOT_ID = "delete from other where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public OtherItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Item item) {
        OtherItem otherItem = (OtherItem) item;
        jdbcTemplate.update(INSERT, otherItem.getLotId());
    }

    @Override
    public Optional<Item> findByLotId(Integer lotId) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID,
                new Object[]{lotId}, new OtherRowMapper()));
    }

    public List<OtherItem> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new OtherRowMapper());
    }

    @Override
    public void deleteByLotId(Integer lotId) {
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }

    @Override
    public ItemType getType() {
        return ItemType.OTHER;
    }
}
