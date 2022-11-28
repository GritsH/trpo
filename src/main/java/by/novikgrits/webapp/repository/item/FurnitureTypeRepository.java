package by.novikgrits.webapp.repository.item;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FurnitureTypeRepository {
    private static final String SELECT_ALL = "select * from furniture_type";
    private final JdbcTemplate jdbcTemplate;

    public FurnitureTypeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<Integer, String> finalAll(){
        return jdbcTemplate.query(SELECT_ALL, new HashMap<Integer, String>);
    }
}
