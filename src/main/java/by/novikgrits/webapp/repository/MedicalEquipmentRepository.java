package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.MedicalEquipmentRowMapper;
import by.novikgrits.webapp.model.MedicalEquipment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MedicalEquipmentRepository {
    private static final String INSERT = "insert into medical_equipment (lot_id, speciality_id, brand, manufacture_year) values (?,?,?,?)";
    private static final String SELECT_BY_LOT_ID = "select * from medical_equipment where lot_id = ?";
    private static final String SELECT_ALL = "select * from medical_equipment";
    private static final String DELETE_BY_LOT_ID = "delete from medical_equipment where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public MedicalEquipmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(MedicalEquipment medicalEquipment){
        jdbcTemplate.update(INSERT,
                medicalEquipment.getLotId(), medicalEquipment.getSpecialityId(),medicalEquipment.getBrand(),
                medicalEquipment.getManufactureYear());
    }

    public Optional<MedicalEquipment> findByLotId(Integer lotId){
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID,
                new Object[]{lotId}, new MedicalEquipmentRowMapper()));
    }

    public List<MedicalEquipment> findAll(){
        return jdbcTemplate.query(SELECT_ALL, new MedicalEquipmentRowMapper());
    }

    public void deleteByLotId(Integer lotId){
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }
}
