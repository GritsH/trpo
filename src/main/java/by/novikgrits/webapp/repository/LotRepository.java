package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.LotRowMapper;
import by.novikgrits.webapp.model.Lot;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LotRepository {
    public final static String INSERT = "insert into lot (starting_date, closing_date, starting_price, step, " +
            "current_price, location_id, brief_info, owner_id, lot_name, status_id) values (?,?,?,?,?,?,?,?,?,?)";
    public final static String DELETE = "delete from lot where id = ?";
    public final static String SELECT_BY_ID = "select * from lot where id = ?";
    public final static String SELECT_BY_OWNER_ID = "select * from lot where owner_id = ?";
    public final static String SELECT_ALL = "select * from lot";
    public final static String SELECT_ALL_ACTIVE = "select * from lot where status_id = 1";
    public final static String SELECT_ALL_CLOSED = "select * from lot where status_id = 2";
    public final static String SELECT_ALL_SOLD = "select * from lot where status_id = 3";
    public final static String UPDATE = "update lot set starting_date = ?, closing_date = ?, " +
            "starting_price = ?, step = ?, current_price = ?, " +
            "location_id = ?, brief_info = ?, " +
            "owner_id = ?, lot_name = ?, status_id = ? where id = ?";
    private final JdbcTemplate jdbcTemplate;

    public LotRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Lot lot){
        jdbcTemplate.update(INSERT, lot.getStartingDate(), lot.getClosingDate(), lot.getStartingPrice(), lot.getStep(),
                0.00, lot.getLocationId(), lot.getBriefInfo(), lot.getOwnerId(), lot.getLotName(), lot.getStatusId());
    }

    public boolean deleteById(Integer id){
        return jdbcTemplate.update(DELETE, id) == 1;
    }

    public Optional<Lot> findById(Integer id){
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id}, new LotRowMapper()));
    }

    public List<Lot> findAll(){
        return jdbcTemplate.queryForList(SELECT_ALL, Lot.class);
    }

    public List<Lot> findAllByOwnerId(Integer ownerId){
        return jdbcTemplate.queryForList(SELECT_BY_OWNER_ID, new Object[]{ownerId}, Lot.class);
    }


    public List<Lot> findAllActive(){
        return jdbcTemplate.queryForList(SELECT_ALL_ACTIVE, Lot.class);
    }

    public List<Lot> findAllClosed(){
        return jdbcTemplate.queryForList(SELECT_ALL_CLOSED, Lot.class);
    }

    public List<Lot> findAllSold(){
        return jdbcTemplate.queryForList(SELECT_ALL_SOLD, Lot.class);
    }

    public void update (Lot lot){
        jdbcTemplate.update(UPDATE,
                lot.getStartingDate(), lot.getClosingDate(), lot.getStartingPrice(),
                lot.getStep(), lot.getCurrentPrice(), lot.getLocationId(),
                lot.getBriefInfo(), lot.getOwnerId(), lot.getLotName(),
                lot.getStatusId(), lot.getId());
    }

}
