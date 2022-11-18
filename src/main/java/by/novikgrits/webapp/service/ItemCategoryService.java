package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.ItemCategory;
import by.novikgrits.webapp.repository.ItemCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCategoryService {
    private final ItemCategoryRepository itemCategoryRepository;

    public ItemCategoryService(ItemCategoryRepository itemCategoryRepository) {
        this.itemCategoryRepository = itemCategoryRepository;
    }

    public List<ItemCategory> getAllCategories() {
        return itemCategoryRepository.findAll();
    }

    public Optional<ItemCategory> getByName(String name) {
        return itemCategoryRepository.findLotCategoryByCategoryName(name);
    }

}
