package by.novikgrits.webapp.repository.item;

import by.novikgrits.webapp.mapper.CarRowMapper;
import by.novikgrits.webapp.model.item.Car;
import by.novikgrits.webapp.model.item.Item;
import by.novikgrits.webapp.model.item.ItemType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository implements ItemRepository {
    private static final String INSERT = "insert into car (lot_id, brand, manufacture_year, mileage, engine_volume) values (?,?,?,?,?)";
    private static final String SELECT_BY_LOT_ID = "select * from car where lot_id = ?";
    private static final String SELECT_ALL = "select * from car";
    private static final String DELETE_BY_ID = "delete from car where id = ?";
    private static final String DELETE_BY_LOT_ID = "delete from car where lot_id = ?";
    private final JdbcTemplate jdbcTemplate;

    public CarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Item item) {
        Car car = (Car) item;
        jdbcTemplate.update(INSERT,
                car.getLotId(), car.getBrand(), car.getManufactureYear(), car.getMileage(), car.getEngineVolume());
    }

    @Override
    public Optional<Item> findByLotId(Integer lotId) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_LOT_ID, new Object[]{lotId}, new CarRowMapper()));
    }

    public List<Car> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new CarRowMapper());
    }

    public void deleteById(Integer carId) {
        jdbcTemplate.update(DELETE_BY_ID, carId);
    }

    public void deleteByLotId(Integer lotId) {
        jdbcTemplate.update(DELETE_BY_LOT_ID, lotId);
    }

    @Override
    public ItemType getType() {
        return ItemType.CAR;
    }
}
