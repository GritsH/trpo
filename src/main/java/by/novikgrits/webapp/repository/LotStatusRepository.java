package by.novikgrits.webapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LotStatusRepository {
    private static final String SELECT_BY_STATUS_NAME = "select id from lot_status where status_name = ?";
    private final JdbcTemplate jdbcTemplate;

    public LotStatusRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer findStatusByName(String name){
        return jdbcTemplate.queryForObject(SELECT_BY_STATUS_NAME, new Object[]{name}, Integer.class);
    }
}
