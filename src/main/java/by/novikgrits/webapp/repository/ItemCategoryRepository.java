package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.mapper.CategoryRowMapper;
import by.novikgrits.webapp.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemCategoryRepository {
    private final static String SELECT_ALL = "select * from item_category";
    private final static String SELECT_BY_NAME = "select * from item_category where category_name = ?";
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Autowired
    public ItemCategoryRepository() {
    }

    public List<ItemCategory> findAll(){
        return jdbcTemplate.queryForList(SELECT_ALL, ItemCategory.class);
    }
    public Optional<ItemCategory> findLotCategoryByCategoryName(String name){
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_BY_NAME,
                new Object[]{name}, new CategoryRowMapper()));
    }
}
