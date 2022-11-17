package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.UserRowMapper;
import by.novikgrits.webapp.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    private final static String INSERT = "insert into user(role_id, first_name, last_name, email," +
            " user_password, phone, passport_data) values(?,?,?,?,?,?,?)";
    private final static String SELECT_BY_EMAIL = "select * from user where email = ?";
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        jdbcTemplate.update(INSERT,
                user.getRoleId(), user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword(), user.getPhone(), user.getPassword());

    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_EMAIL,
                new Object[]{email}, new UserRowMapper()));

    }

}
