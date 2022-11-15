package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.model.ItemCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LotCategoryRepository extends CrudRepository<ItemCategory, Integer> {
    Optional<ItemCategory> findLotCategoryByCategoryName(String name);
}
