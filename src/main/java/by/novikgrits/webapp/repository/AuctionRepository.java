package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.model.*;
import by.novikgrits.webapp.model.item.*;
import by.novikgrits.webapp.repository.item.ItemRepositoryProvider;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuctionRepository {
    private final ItemRepositoryProvider itemRepositoryProvider;
    private final LotRepository lotRepository;

    public AuctionRepository(LotRepository lotRepository, ItemRepositoryProvider itemRepositoryProvider) {
        this.lotRepository = lotRepository;
        this.itemRepositoryProvider = itemRepositoryProvider;
    }


    public List<Auction> findAllItemsForLots(List<Lot> lots) {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            ItemType itemType = lot.getItemType();
            Auction auction = new Auction();
            auction.setLot(lot);
            Item foundItem = itemRepositoryProvider.findRepoByType(itemType).
                    findByLotId(lot.getId()).orElseThrow(RuntimeException::new);
            auction.setItem(foundItem);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findLotsByTypeAndStatus(ItemType itemType, Integer statusId){
        List<Auction> auctions = new ArrayList<>();
        Auction auction = new Auction();
        List<Lot> foundLots = lotRepository.findLotsByTypeAndStatus(itemType.toString(), statusId);
        for (Lot lot : foundLots) {
            Item item = itemRepositoryProvider.findRepoByType(itemType).
                    findByLotId(lot.getId()).orElseThrow(RuntimeException::new);
            auction.setItem(item);
            auction.setLot(lot);
            auctions.add(auction);
        }
        return auctions;
    }

    public Auction findAuctionByLotId(Integer id) {
        Lot foundLot = lotRepository.findById(id).orElseThrow(RuntimeException::new);
        ItemType itemType = foundLot.getItemType();
        Item item = itemRepositoryProvider.findRepoByType(itemType).findByLotId(id).orElseThrow(RuntimeException::new);

        Auction auction = new Auction();
        auction.setItem(item);
        auction.setLot(foundLot);
        return auction;
    }
}
