package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.ClothesRowMapper;
import by.novikgrits.webapp.model.Clothes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClothesRepository {
    private static final String INSERT = "insert into clothes (lot_id, brand, material, size) values (?,?,?,?)";
    private static final String SELECT_BY_LOT_ID = "select * from clothes where lot_id = ?";
    private static final String SELECT_ALL = "select * from clothes";
    private static final String DELETE_BY_LOT_ID = "delete from clothes where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public ClothesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Clothes clothes){
        jdbcTemplate.update(INSERT,
                clothes.getLotId(), clothes.getBrand(), clothes.getMaterial(), clothes.getSize());
    }

    public Optional<Clothes> findByLotId(Integer lotId){
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID, new Object[]{lotId}, new ClothesRowMapper()));
    }

    public List<Clothes> findAll(){
        return jdbcTemplate.query(SELECT_ALL, new ClothesRowMapper());
    }

    public void deleteByLotId(Integer lotId){
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }
}
