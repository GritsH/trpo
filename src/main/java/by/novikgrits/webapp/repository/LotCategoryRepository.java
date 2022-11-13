package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.model.LotCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LotCategoryRepository extends CrudRepository<LotCategory, Integer> {
    Optional<LotCategory> findLotCategoryByCategoryName(String name);
}
