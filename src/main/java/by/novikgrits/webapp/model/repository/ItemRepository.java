package by.novikgrits.webapp.model.repository;

import by.novikgrits.webapp.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
