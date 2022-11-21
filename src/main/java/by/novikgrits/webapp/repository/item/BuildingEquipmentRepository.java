package by.novikgrits.webapp.repository.item;

import by.novikgrits.webapp.mapper.BuildingEquipmentRowMapper;
import by.novikgrits.webapp.model.item.BuildingEquipment;
import by.novikgrits.webapp.model.item.Item;
import by.novikgrits.webapp.model.item.ItemType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuildingEquipmentRepository implements ItemRepository {
    private static final String INSERT = "insert into building_equipment (lot_id, brand) values(?,?)";
    private static final String SELECT_BY_LOT_ID = "select * from building_equipment where lot_id = ?";
    private static final String SELECT_ALL = "select * from building_equipment";
    private static final String DELETE_BY_LOT_ID = "delete from building_equipment where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public BuildingEquipmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Item item) {
        BuildingEquipment buildingEquipment = (BuildingEquipment) item;
        jdbcTemplate.update(INSERT,
                buildingEquipment.getLotId(), buildingEquipment.getBrand());
    }

    @Override
    public Optional<Item> findByLotId(Integer id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID, new Object[]{id}, new BuildingEquipmentRowMapper()));
    }

    public List<BuildingEquipment> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new BuildingEquipmentRowMapper());
    }

    public void deleteByLotId(Integer lotId) {
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }

    @Override
    public ItemType getType() {
        return ItemType.BUILDING_EQUIPMENT;
    }
}
