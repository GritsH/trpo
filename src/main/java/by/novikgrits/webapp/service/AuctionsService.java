package by.novikgrits.webapp.service;

import by.novikgrits.webapp.dao.AuctionDao;
import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.item.ItemType;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AuctionsService {
    private AuctionDao auctionDao;

    public AuctionsService(AuctionDao auctionDao) {
        this.auctionDao = auctionDao;
    }

    public List<Auction> getAllAuctions(List<Lot> lots) throws SQLException {
        return auctionDao.findAllAuctions(lots);
    }

    public List<Auction> getByTypeAndStatus(ItemType itemType, Integer statusId) throws SQLException {
        return auctionDao.findByTypeAndStatus(itemType, statusId);
    }

    public Auction getAuctionByLotId(Integer id) throws SQLException {
        return auctionDao.findLotById(id);
    }
}
