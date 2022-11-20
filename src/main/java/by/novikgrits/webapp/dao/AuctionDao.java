package by.novikgrits.webapp.dao;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.repository.AuctionRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AuctionDao {
    private final AuctionRepository auctionRepository;

    public AuctionDao(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public List<Auction> findAuctions(List<Lot> lots){
        return Stream.of(auctionRepository.findCarsForLots(lots),
                auctionRepository.findJewelryForLots(lots),
                auctionRepository.findEstateForLots(lots)).flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
