package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.item.ItemType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LotRowMapper implements RowMapper<Lot> {
    @Override
    public Lot mapRow(ResultSet rs, int rowNum) throws SQLException {
        Lot lot = new Lot();

        lot.setId(rs.getInt("id"));
        lot.setLotName(rs.getString("lot_name"));
        lot.setBriefInfo(rs.getString("brief_info"));
        lot.setStartingDate(rs.getDate("starting_date").toLocalDate());
        lot.setClosingDate(rs.getDate("closing_date").toLocalDate());
        lot.setStartingPrice(rs.getDouble("starting_price"));
        lot.setStep(rs.getDouble("step"));
        lot.setCurrentPrice(rs.getDouble("current_price"));
        lot.setOwnerId(rs.getInt("owner_id"));
        lot.setStatusId(rs.getInt("status_id"));
        lot.setItemType(ItemType.valueOf(rs.getString("item_type")));

        return lot;
    }
}
