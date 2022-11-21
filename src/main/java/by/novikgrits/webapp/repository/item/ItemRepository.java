package by.novikgrits.webapp.repository.item;

import by.novikgrits.webapp.model.item.Item;
import by.novikgrits.webapp.model.item.ItemType;

import java.util.Optional;

public interface ItemRepository {

    void save(Item item);

    Optional<Item> findByLotId(Integer id);

    ItemType getType();
}
