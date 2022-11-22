package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.item.SportEquipment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SportEquipmentRowMapper implements RowMapper<SportEquipment> {
    @Override
    public SportEquipment mapRow(ResultSet rs, int rowNum) throws SQLException {
        SportEquipment sportEquipment = new SportEquipment();

        sportEquipment.setId(rs.getInt("id"));
        sportEquipment.setBrand(rs.getString("brand"));
        sportEquipment.setWeight(rs.getFloat("weight"));
        sportEquipment.setLotId(rs.getInt("lot_id"));

        return sportEquipment;
    }
}
