package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.repository.ItemRepository;
import by.novikgrits.webapp.model.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LotService {
    @Autowired
    private LotRepository lotRepository;
    @Autowired
    private ItemRepository itemRepository;

    public void addLot(Lot lot) {
        lotRepository.save(lot);
    }

    public Optional<Lot> findById(Integer id) {
        return lotRepository.findById(id);
    }

    public void deleteById(Integer id) {
        Optional<Lot> lot = findById(id);
        Integer itemId = lot.get().getItemId();
        itemRepository.deleteById(itemId);
        lotRepository.deleteById(id);
    }

    public List<Lot> findAll() {
        List<Lot> foundLots = (List<Lot>) lotRepository.findAll();
        Collections.sort(foundLots);
        return foundLots;
    }


}
