package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.item.OtherItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OtherRowMapper implements RowMapper<OtherItem> {
    @Override
    public OtherItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        OtherItem otherItem = new OtherItem();

        otherItem.setId(rs.getInt("id"));
        otherItem.setLotId(rs.getInt("lot_id"));

        return otherItem;
    }
}
