package by.novikgrits.webapp.repository.item;

import by.novikgrits.webapp.mapper.MedicalEquipmentRowMapper;
import by.novikgrits.webapp.model.item.Item;
import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.model.item.MedicalEquipment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MedicalEquipmentRepository implements ItemRepository {
    private static final String INSERT = "insert into medical_equipment (lot_id, speciality_id, brand, manufacture_year) values (?,?,?,?)";
    private static final String SELECT_BY_LOT_ID = "select * from medical_equipment where lot_id = ?";
    private static final String SELECT_ALL = "select * from medical_equipment";
    private static final String DELETE_BY_LOT_ID = "delete from medical_equipment where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public MedicalEquipmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Item item) {
        MedicalEquipment medicalEquipment = (MedicalEquipment) item;
        jdbcTemplate.update(INSERT,
                medicalEquipment.getLotId(), medicalEquipment.getSpecialityId(), medicalEquipment.getBrand(),
                medicalEquipment.getManufactureYear());
    }

    @Override
    public Optional<Item> findByLotId(Integer lotId) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID,
                new Object[]{lotId}, new MedicalEquipmentRowMapper()));
    }

    public List<MedicalEquipment> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new MedicalEquipmentRowMapper());
    }

    public void deleteByLotId(Integer lotId) {
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }

    @Override
    public ItemType getType() {
        return ItemType.MEDICAL_EQUIPMENT;
    }
}
