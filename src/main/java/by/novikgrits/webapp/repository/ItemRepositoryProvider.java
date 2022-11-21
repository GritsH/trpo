package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.repository.item.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ItemRepositoryProvider {

    private final Map<ItemType, ItemRepository> itemReposByType;

    public ItemRepositoryProvider(List<ItemRepository> itemRepositories) {
        this.itemReposByType = itemRepositories.stream()
                .collect(Collectors.toMap(ItemRepository::getType, Function.identity()));
    }

    public ItemRepository findRepoByType(ItemType itemType) {
        return itemReposByType.get(itemType);
    }
}
