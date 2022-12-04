package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.item.MedicalEquipment;
import by.novikgrits.webapp.model.item.MedicalSpeciality;
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
        medicalEquipment.setLotId(rs.getInt("lot_id"));
        medicalEquipment.setMedicalSpeciality(MedicalSpeciality.getByName(rs.getString("type")));

        return medicalEquipment;
    }
}
