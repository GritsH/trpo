package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.item.BuildingEquipment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingEquipmentRowMapper implements RowMapper<BuildingEquipment> {
    @Override
    public BuildingEquipment mapRow(ResultSet rs, int rowNum) throws SQLException {
        BuildingEquipment buildingEquipment = new BuildingEquipment();

        buildingEquipment.setId(rs.getInt("id"));
        buildingEquipment.setBrand(rs.getString("brand"));
        buildingEquipment.setLotId(rs.getInt("lot_id"));

        return buildingEquipment;
    }
}
