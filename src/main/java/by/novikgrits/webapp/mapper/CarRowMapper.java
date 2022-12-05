package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.item.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();

        car.setId(rs.getInt("id"));
        car.setBrand(rs.getString("brand"));
        car.setMileage(rs.getInt("mileage"));
        car.setEngineVolume(rs.getInt("engine_volume"));
        car.setManufactureYear(rs.getInt("manufacture_year"));
        car.setLotId(rs.getInt("lot_id"));

        return car;
    }
}
