package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.ItemCategory;
import by.novikgrits.webapp.repository.LotCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotCategoryService {
    @Autowired
    private LotCategoryRepository lotCategoryRepository;

    public List<ItemCategory> getAllCategories() {
        return (List<ItemCategory>) lotCategoryRepository.findAll();
    }

    public Optional<ItemCategory> getByName(String name) {
        return lotCategoryRepository.findLotCategoryByCategoryName(name);
    }

}
