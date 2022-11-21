package by.novikgrits.webapp.service;

import by.novikgrits.webapp.dao.AuctionDao;
import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.item.ItemType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionsService {
    private AuctionDao auctionDao;

    public AuctionsService(AuctionDao auctionDao) {
        this.auctionDao = auctionDao;
    }

    public List<Auction> getAllAuctions(List<Lot> lots) {
        return auctionDao.findAllAuctions(lots);
    }

    public List<Auction> getByTypeAndStatus(ItemType itemType, Integer statusId){
        return auctionDao.findByTypeAndStatus(itemType, statusId);
    }

    public Auction getAuctionByLotId(Integer id){
        return auctionDao.findLotById(id);
    }
}
