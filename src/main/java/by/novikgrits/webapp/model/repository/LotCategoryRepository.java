package by.novikgrits.webapp.model.repository;

import by.novikgrits.webapp.model.LotCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotCategoryRepository extends CrudRepository<LotCategory, Long> {
}
