package by.novikgrits.webapp.model.repository;

import by.novikgrits.webapp.model.BidHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidHistoryRepository extends CrudRepository<BidHistory, Integer> {
    List<BidHistory> findAllByBidderEmailAndLotId(String bidderEmail, Integer lotId);
    List<BidHistory> findAllByBidderEmail(String bidderEmail);
    List<BidHistory> findAllByLotId(Integer id);
}
