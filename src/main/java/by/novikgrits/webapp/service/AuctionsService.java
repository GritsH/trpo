package by.novikgrits.webapp.service;

import by.novikgrits.webapp.dao.AuctionDao;
import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionsService {
    private AuctionDao auctionDao;

    public AuctionsService(AuctionDao auctionDao) {
        this.auctionDao = auctionDao;
    }

    public List<Auction> getAuctions(List<Lot> lots) {
        return auctionDao.findAuctions(lots);
    }

}
