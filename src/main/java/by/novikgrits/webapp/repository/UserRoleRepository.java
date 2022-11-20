package by.novikgrits.webapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleRepository {
    private static final String SELECT_BY_ID = "select role_name from user_role where id = ?";
    private final JdbcTemplate jdbcTemplate;


    public UserRoleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String findByRoleId(Integer id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id}, String.class);
    }
}
