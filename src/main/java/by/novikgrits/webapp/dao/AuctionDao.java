package by.novikgrits.webapp.dao;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.repository.AuctionRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AuctionDao {
    private final AuctionRepository auctionRepository;

    public AuctionDao(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public List<Auction> findAllAuctions(List<Lot> lots) {
        return auctionRepository.findAllItemsForLots(lots);
    }

    public List<Auction> findByTypeAndStatus(ItemType itemType, Integer status){
        return auctionRepository.findLotsByTypeAndStatus(itemType, status);
    }

    public Auction findLotById(Integer id){
        return auctionRepository.findAuctionByLotId(id);
    }
}
