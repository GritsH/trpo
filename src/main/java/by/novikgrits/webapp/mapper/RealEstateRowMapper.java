package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.RealEstate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RealEstateRowMapper implements RowMapper<RealEstate> {
    @Override
    public RealEstate mapRow(ResultSet rs, int rowNum) throws SQLException {
        RealEstate realEstate = new RealEstate();

        realEstate.setId(rs.getInt("id"));
        realEstate.setLivingSpace(rs.getInt("living_space"));
        realEstate.setRoomAmount(rs.getInt("room_amount"));
        realEstate.setLotId(rs.getInt("lot_id"));

        return realEstate;
    }
}
