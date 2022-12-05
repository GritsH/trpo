package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.LotPhoto;
import by.novikgrits.webapp.model.item.Item;
import by.novikgrits.webapp.model.item.ItemType;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Repository
public class AuctionRepository {
    private final ItemRepositoryProvider itemRepositoryProvider;
    private final LotRepository lotRepository;
    private final LotPhotoRepository lotPhotoRepository;

    public AuctionRepository(LotRepository lotRepository, ItemRepositoryProvider itemRepositoryProvider, LotPhotoRepository lotPhotoRepository) {
        this.lotRepository = lotRepository;
        this.itemRepositoryProvider = itemRepositoryProvider;
        this.lotPhotoRepository = lotPhotoRepository;
    }


    public List<Auction> findAllItemsForLots(List<Lot> lots) throws SQLException {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            ItemType itemType = lot.getItemType();
            Auction auction = new Auction();
            auction.setLot(lot);
            getItem(itemType, lot, auction);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findLotsByTypeAndStatus(ItemType itemType, Integer statusId) throws SQLException {
        List<Auction> auctions = new ArrayList<>();
        List<Lot> foundLots = lotRepository.findLotsByTypeAndStatus(itemType.getTypeDescription(), statusId);
        for (Lot lot : foundLots) {
            Auction auction = new Auction();
            getItem(itemType, lot, auction);
            auction.setLot(lot);
            auctions.add(auction);
        }
        return auctions;
    }


    public Auction findAuctionByLotId(Integer id) throws SQLException {
        Lot foundLot = lotRepository.findById(id).orElseThrow(RuntimeException::new);
        ItemType itemType = foundLot.getItemType();
        Item item = itemRepositoryProvider.findRepoByType(itemType).findByLotId(id).orElseThrow(RuntimeException::new);
        LotPhoto lotPhoto = lotPhotoRepository.findByLotId(id).get();

        Auction auction = new Auction();
        auction.setItem(item);
        auction.setLot(foundLot);
        auction.setPic(Base64.getEncoder().encodeToString(lotPhoto.getPhoto().getBytes(1L, (int) lotPhoto.getPhoto().length())));
        return auction;
    }

    private void getItem(ItemType itemType, Lot lot, Auction auction) throws SQLException {
        Item item = itemRepositoryProvider.findRepoByType(itemType).
                findByLotId(lot.getId()).orElseThrow(RuntimeException::new);
        LotPhoto lotPhoto = lotPhotoRepository.findByLotId(lot.getId()).orElseThrow(RuntimeException::new);

        auction.setPic(Base64.getEncoder().encodeToString(lotPhoto.getPhoto().getBytes(0L, (int) lotPhoto.getPhoto().length())));
        auction.setItem(item);
    }
}
