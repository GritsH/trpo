package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.Clothes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClothesRowMapper implements RowMapper<Clothes> {
    @Override
    public Clothes mapRow(ResultSet rs, int rowNum) throws SQLException {
        Clothes clothes = new Clothes();

        clothes.setId(rs.getInt("id"));
        clothes.setMaterial(rs.getString("material"));
        clothes.setSize(rs.getInt("size"));
        clothes.setBrand(rs.getString("brand"));
        clothes.setLotId(rs.getInt("lot_id"));

        return clothes;
    }
}
