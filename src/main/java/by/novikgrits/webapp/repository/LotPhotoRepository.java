package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.LotPhotoMapper;
import by.novikgrits.webapp.model.LotPhoto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LotPhotoRepository {
    public static final String INSERT = "insert into lot_photo (lot_id, photo) values (?,?)";
    public static final String DELETE = "delete from lot_photo where lot_id = ?";
    public static final String SELECT_BY_LOT_ID = "select * from lot_photo where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public LotPhotoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(LotPhoto lotPhoto) {
        jdbcTemplate.update(INSERT, lotPhoto.getLotId(), lotPhoto.getPhoto());
    }

    public Optional<LotPhoto> findByLotId(Integer id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID, new Object[]{id}, new LotPhotoMapper()));
    }

    public void deleteByLotId(Integer id) {
        jdbcTemplate.update(DELETE, id);
    }
}
