package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.item.Jewelry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JewelryRowMapper implements RowMapper<Jewelry> {
    @Override
    public Jewelry mapRow(ResultSet rs, int rowNum) throws SQLException {
        Jewelry jewelry = new Jewelry();

        jewelry.setId(rs.getInt("id"));
        jewelry.setMaterial(rs.getString("material"));
        jewelry.setLotId(rs.getInt("lot_id"));
        jewelry.setHasPreciousStones(rs.getBoolean("has_precious_stones"));

        return jewelry;
    }
}
