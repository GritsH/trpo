package by.novikgrits.webapp.mapper;

import by.novikgrits.webapp.model.ItemCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<ItemCategory> {
    @Override
    public ItemCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemCategory itemCategory = new ItemCategory();

        itemCategory.setId(rs.getInt("id"));
        itemCategory.setCategoryName(rs.getString("category_name"));
        return itemCategory;
    }
}
