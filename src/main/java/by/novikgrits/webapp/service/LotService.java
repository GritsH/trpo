package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.repository.LotRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LotService {
    private final LotRepository lotRepository;

    public LotService(LotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }


    public Optional<Lot> findById(Integer id) {
        return lotRepository.findById(id);
    }

    public void deleteById(Integer id) {
        lotRepository.deleteById(id);
    }

    public List<Lot> findAll() {
        List<Lot> foundLots = lotRepository.findAll();
        Collections.sort(foundLots);
        return foundLots;
    }

    public List<Lot> findAllActive() {
        return lotRepository.findAllActive();
    }

    public List<Lot> findAllClosed() {
        return lotRepository.findAllClosed();
    }

    public List<Lot> findAllSold() {
        return lotRepository.findAllSold();
    }

    public List<Lot> findByOwnerId(Integer ownerId) {
        return lotRepository.findAllByOwnerId(ownerId);
    }

    public void updateLot(Lot lot) {
        lotRepository.update(lot);
    }

}
