package by.novikgrits.webapp.repository.item;

import by.novikgrits.webapp.mapper.JewelryRowMapper;
import by.novikgrits.webapp.model.item.Item;
import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.model.item.Jewelry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JewelryRepository implements ItemRepository {
    private static final String INSERT = "insert into jewelry (material, has_precious_stones, lot_id) values (?,?,?)";
    private static final String SELECT_BY_LOT_ID = "select * from jewelry where lot_id = ?";
    private static final String SELECT_ALL = "select * from jewelry";
    private static final String DELETE_BY_ID = "delete from jewelry where id = ?";
    private static final String DELETE_BY_LOT_ID = "delete from jewelry where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public JewelryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Item item) {
        Jewelry jewelry = (Jewelry) item;
        jdbcTemplate.update(INSERT, jewelry.getMaterial(), jewelry.getHasPreciousStones(), jewelry.getLotId());
    }

    @Override
    public Optional<Item> findByLotId(Integer id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID, new Object[]{id}, new JewelryRowMapper()));
    }

    public List<Jewelry> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new JewelryRowMapper());
    }

    @Override
    public void deleteByLotId(Integer lotId) {
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }

    @Override
    public ItemType getType() {
        return ItemType.JEWELRY;
    }
}
