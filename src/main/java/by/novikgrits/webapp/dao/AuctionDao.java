package by.novikgrits.webapp.dao;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.repository.AuctionRepository;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class AuctionDao {
    private final AuctionRepository auctionRepository;

    public AuctionDao(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public List<Auction> findAllAuctions(List<Lot> lots) throws SQLException {
        return auctionRepository.findAllItemsForLots(lots);
    }

    public List<Auction> findByTypeAndStatus(ItemType itemType, Integer status) throws SQLException {
        return auctionRepository.findLotsByTypeAndStatus(itemType, status);
    }

    public Auction findLotById(Integer id) throws SQLException {
        return auctionRepository.findAuctionByLotId(id);
    }
}
