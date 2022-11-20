package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.Furniture;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FurnitureRowMapper implements RowMapper<Furniture> {
    @Override
    public Furniture mapRow(ResultSet rs, int rowNum) throws SQLException {
        Furniture furniture = new Furniture();

        furniture.setId(rs.getInt("id"));
        furniture.setFurnitureTypeId(rs.getInt("furniture_type_id"));
        furniture.setMaterial(rs.getString("material"));
        furniture.setLotId(rs.getInt("lot_id"));

        return furniture;
    }
}
