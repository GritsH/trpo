package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public UserRepository(){
    }

    public int save(User user) {
       return jdbcTemplate.update("insert into user(role_id, status_id, first_name, last_name, email," +
                       " user_password, phone, passport_data) values(?,?,?,?,?,?,?,?)",
               user.getRoleId(),user.getStatusId(), user.getFirstName(), user.getLastName(),
               user.getEmail(), user.getPassword(), user.getPhone(), user.getPassword());

    }


}
