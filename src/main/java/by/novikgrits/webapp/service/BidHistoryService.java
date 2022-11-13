package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.BidHistory;
import by.novikgrits.webapp.repository.BidHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BidHistoryService {
    @Autowired
    private BidHistoryRepository bidHistoryRepository;

    public void addHistory(BidHistory bidHistory) {
        bidHistoryRepository.save(bidHistory);
    }

    public Optional<BidHistory> findById(Integer id) {
        return bidHistoryRepository.findById(id);
    }

    public List<BidHistory> findAll() {
        List<BidHistory> foundHistories = (List<BidHistory>) bidHistoryRepository.findAll();
        Collections.sort(foundHistories);
        return foundHistories;
    }

    public List<BidHistory> findByBidderEmailAndLotId(String email, Integer lotId) {
        List<BidHistory> foundHistories = bidHistoryRepository.findAllByBidderEmailAndLotId(email, lotId);
        Collections.sort(foundHistories);
        return foundHistories;
    }

    public List<BidHistory> findByBidderEmail(String email) {
        List<BidHistory> foundHistories = bidHistoryRepository.findAllByBidderEmail(email);
        Collections.sort(foundHistories);
        return foundHistories;
    }

    public List<BidHistory> findByLotId(Integer id) {
        List<BidHistory> foundHistories = bidHistoryRepository.findAllByLotId(id);
        Collections.sort(foundHistories);
        return foundHistories;
    }
}
