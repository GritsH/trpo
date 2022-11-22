package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.CategoryRowMapper;
import by.novikgrits.webapp.model.ItemCategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemCategoryRepository {
    private static final String SELECT_ALL = "select * from item_category";
    private static final String SELECT_BY_NAME = "select * from item_category where category_name = ?";
    private static final String SELECT_BY_ID = "select category_name from item_category where id = ?";
    private final JdbcTemplate jdbcTemplate;

    public ItemCategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ItemCategory> findAll() {
        List<ItemCategory> allCategories = jdbcTemplate.query(SELECT_ALL, new CategoryRowMapper());
        return allCategories;
    }

    public Optional<ItemCategory> findLotCategoryByCategoryName(String name) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_NAME,
                new Object[]{name}, new CategoryRowMapper()));
    }

    public String findById(Integer id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id}, String.class);
    }
}
