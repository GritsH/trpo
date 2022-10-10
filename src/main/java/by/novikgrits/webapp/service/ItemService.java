package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.Item;
import by.novikgrits.webapp.model.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> getAllItems(){
        return (List<Item>) itemRepository.findAll();
    }

    public void deleteById(Integer id){
        itemRepository.deleteById(id);
    }

    public Optional<Item> getById(Integer id){
        return itemRepository.findById(id);
    }
}
