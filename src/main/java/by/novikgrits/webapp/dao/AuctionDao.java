package by.novikgrits.webapp.dao;

import by.novikgrits.webapp.model.Auction;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.repository.AuctionRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public List<Auction> findAllAuctions(List<Lot> lots) {
        return Stream.of(auctionRepository.findCarsForLots(lots),
                        auctionRepository.findJewelryForLots(lots),
                        auctionRepository.findEstateForLots(lots),
                        auctionRepository.findBuildingEquipmentForLots(lots),
                        auctionRepository.findMedicalEquipmentForLots(lots),
                        auctionRepository.findOtherItemsForLots(lots),
                        auctionRepository.findClothesForLots(lots),
                        auctionRepository.findFurnitureForLots(lots),
                        auctionRepository.findSportEquipmentForLots(lots)).flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Auction> findAllCars(List<Lot> lots){
        return auctionRepository.findCarsForLots(lots);
    }

    public List<Auction> findAllEstate(List<Lot> lots){
        return auctionRepository.findEstateForLots(lots);
    }

    public List<Auction> findAllJewelry(List<Lot> lots){
        return auctionRepository.findJewelryForLots(lots);
    }

    public List<Auction> findAllClothes(List<Lot> lots){
        return auctionRepository.findClothesForLots(lots);
    }

    public List<Auction> findAllFurniture(List<Lot> lots){
        return auctionRepository.findFurnitureForLots(lots);
    }

    public List<Auction> findAllBuildingEquipment(List<Lot> lots){
        return auctionRepository.findBuildingEquipmentForLots(lots);
    }

    public List<Auction> findAllSportEquipment(List<Lot> lots){
        return auctionRepository.findSportEquipmentForLots(lots);
    }

    public List<Auction> findAllMedicalEquipment(List<Lot> lots){
        return auctionRepository.findMedicalEquipmentForLots(lots);
    }

    public List<Auction> findAllOther(List<Lot> lots){
        return auctionRepository.findOtherItemsForLots(lots);
    }
}
