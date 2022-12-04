package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.item.Furniture;
import by.novikgrits.webapp.model.item.FurnitureType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FurnitureRowMapper implements RowMapper<Furniture> {
    @Override
    public Furniture mapRow(ResultSet rs, int rowNum) throws SQLException {
        Furniture furniture = new Furniture();

        furniture.setId(rs.getInt("id"));
        furniture.setMaterial(rs.getString("material"));
        furniture.setLotId(rs.getInt("lot_id"));
        furniture.setFurnitureType(FurnitureType.getByName(rs.getString("type")));

        return furniture;
    }
}
