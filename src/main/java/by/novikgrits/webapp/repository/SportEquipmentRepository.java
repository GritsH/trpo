package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.SportEquipmentRowMapper;
import by.novikgrits.webapp.model.SportEquipment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SportEquipmentRepository {
    private static final String INSERT = "insert into sport_equipment (lot_id, weight, brand) values (?,?,?)";
    private static final String SELECT_BY_LOT_ID = "select * from sport_equipment where lot_id = ?";
    private static final String SELECT_ALL = "select * from sport_equipment";
    private static final String DELETE_BY_LOT_ID = "delete from sport_equipment where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public SportEquipmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(SportEquipment sportEquipment){
        jdbcTemplate.update(INSERT,
                sportEquipment.getLotId(), sportEquipment.getWeight(), sportEquipment.getBrand());
    }

    public Optional<SportEquipment> findByLotId(Integer lotId){
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID, new Object[]{lotId}, new SportEquipmentRowMapper()));
    }

    public List<SportEquipment> findAll(){
        return jdbcTemplate.query(SELECT_ALL, new SportEquipmentRowMapper());
    }

    public void deleteByLotId(Integer lotId){
        jdbcTemplate.update(DELETE_BY_LOT_ID,lotId);
    }
}
