package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.UserRowMapper;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.User;
import by.novikgrits.webapp.model.item.ItemType;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private static final String INSERT = "insert into user(first_name, last_name, email," +
            " user_password, phone, passport_data, role_name) values(?,?,?,?,?,?,?)";
    private static final String SELECT_BY_EMAIL = "select * from user where email = ?";
    private static final String SELECT_BY_ID = "select * from user where id = ?";
    private static final String SELECT_ALL = "select * from user";
    private final JdbcTemplate jdbcTemplate;
    private final LotRepository lotRepository;
    private final BidHistoryRepository bidHistoryRepository;
    private final ItemRepositoryProvider itemRepositoryProvider;
    public UserRepository(JdbcTemplate jdbcTemplate, LotRepository lotRepository, BidHistoryRepository bidHistoryRepository, ItemRepositoryProvider itemRepositoryProvider) {
        this.jdbcTemplate = jdbcTemplate;
        this.lotRepository = lotRepository;
        this.bidHistoryRepository = bidHistoryRepository;
        this.itemRepositoryProvider = itemRepositoryProvider;
    }

    public void save(User user) {
        jdbcTemplate.update(INSERT,
                user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword(), user.getPhone(),
                user.getPassportData(), user.getRoleName());

    }

    public List<User> findAll(){
        return jdbcTemplate.query(SELECT_ALL, new UserRowMapper());
    }

    public Optional<User> findByEmail(String email) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_EMAIL,
                    new UserRowMapper(), email));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id}, new UserRowMapper()));
    }

    @Transactional
    public void deleteUser(Integer userId){
        List<Lot> allUserLots = lotRepository.findAllByOwnerId(userId);
        for (Lot lot: allUserLots) {
            bidHistoryRepository.deleteByLotId(lot.getId());

            ItemType itemType = lot.getItemType();
            itemRepositoryProvider.findRepoByType(itemType).deleteByLotId(lot.getId());

            lotRepository.deleteById(lot.getId());
        }
    }

}
