package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.LotPhoto;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LotPhotoMapper implements RowMapper<LotPhoto> {
    @Override
    public LotPhoto mapRow(ResultSet rs, int rowNum) throws SQLException {
        LotPhoto photo = new LotPhoto();

        photo.setId(rs.getInt("id"));
        photo.setLotId(rs.getInt("lot_id"));
        photo.setPhoto(rs.getBlob("photo"));

        return photo;
    }
}
