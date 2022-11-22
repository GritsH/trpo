package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.item.MedicalEquipment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicalEquipmentRowMapper implements RowMapper<MedicalEquipment> {
    @Override
    public MedicalEquipment mapRow(ResultSet rs, int rowNum) throws SQLException {
        MedicalEquipment medicalEquipment = new MedicalEquipment();

        medicalEquipment.setId(rs.getInt("id"));
        medicalEquipment.setBrand(rs.getString("brand"));
        medicalEquipment.setManufactureYear(rs.getDate("manufacture_year"));
        medicalEquipment.setSpecialityId(rs.getInt("speciality_id"));
        medicalEquipment.setLotId(rs.getInt("lot_id"));

        return medicalEquipment;
    }
}
