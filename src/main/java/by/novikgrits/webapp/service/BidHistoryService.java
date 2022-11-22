package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.BidHistory;
import by.novikgrits.webapp.repository.BidHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BidHistoryService {
    private final BidHistoryRepository bidHistoryRepository;

    public BidHistoryService(BidHistoryRepository bidHistoryRepository) {
        this.bidHistoryRepository = bidHistoryRepository;
    }

    public void addHistory(BidHistory bidHistory) {
        bidHistoryRepository.save(bidHistory);
    }

    public Optional<BidHistory> findById(Integer id) {
        return bidHistoryRepository.findById(id);
    }

    public List<BidHistory> findAll() {
        List<BidHistory> foundHistories = bidHistoryRepository.findAll();
        Collections.sort(foundHistories);
        return foundHistories;
    }

    public List<BidHistory> findByBidderIdAndLotId(Integer bidderId, Integer lotId) {
        List<BidHistory> foundHistories = bidHistoryRepository.findAllByBidderIdAndLotId(bidderId, lotId);
        Collections.sort(foundHistories);
        return foundHistories;
    }

    public List<BidHistory> findByBidderId(Integer bidderId) {
        List<BidHistory> foundHistories = bidHistoryRepository.findAllByBidderId(bidderId);
        Collections.sort(foundHistories);
        return foundHistories;
    }

    public List<BidHistory> findByLotId(Integer id) {
        List<BidHistory> foundHistories = bidHistoryRepository.findAllByLotId(id);
        Collections.sort(foundHistories);
        return foundHistories;
    }

    public List<BidHistory> findLastHistoriesInLots() {
        return bidHistoryRepository.findLastBiddersInLots();
    }

    public List<BidHistory> findByDate(Date date) {
        return bidHistoryRepository.findAllByDate(date);
    }
}
