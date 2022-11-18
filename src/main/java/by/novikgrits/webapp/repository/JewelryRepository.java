package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.model.Jewelry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JewelryRepository {
    private static final String SELECT_BY_LOT_ID = "select * from jewelry where lot_id = ?";
    private static final String SELECT_ALL = "select * from jewelry";
    private static final String DELETE_BY_ID = "delete from jewelry where id = ?";
    private static final String DELETE_BY_LOT_ID = "delete from jewelry where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public JewelryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
