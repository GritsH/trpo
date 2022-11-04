package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.LotCategory;
import by.novikgrits.webapp.model.repository.LotCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotCategoryService {
    @Autowired
    private LotCategoryRepository lotCategoryRepository;

    public List<LotCategory> getAllCategories() {
        return (List<LotCategory>) lotCategoryRepository.findAll();
    }

    public Optional<LotCategory> getByName(String name) {
        return lotCategoryRepository.findLotCategoryByCategoryName(name);
    }

}
