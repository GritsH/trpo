package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuctionRepository {
    private final LotRepository lotRepository;
    private final CarRepository carRepository;
    private final RealEstateRepository realEstateRepository;
    private final JewelryRepository jewelryRepository;
    private final FurnitureRepository furnitureRepository;
    private final ClothesRepository clothesRepository;
    private final SportEquipmentRepository sportEquipmentRepository;
    private final BuildingEquipmentRepository buildingEquipmentRepository;
    private final MedicalEquipmentRepository medicalEquipmentRepository;
    private final OtherItemRepository otherItemRepository;

    public AuctionRepository(LotRepository lotRepository, CarRepository carRepository, RealEstateRepository realEstateRepository, JewelryRepository jewelryRepository, FurnitureRepository furnitureRepository, ClothesRepository clothesRepository, SportEquipmentRepository sportEquipmentRepository, BuildingEquipmentRepository buildingEquipmentRepository, MedicalEquipmentRepository medicalEquipmentRepository, OtherItemRepository otherItemRepository) {
        this.lotRepository = lotRepository;
        this.carRepository = carRepository;
        this.realEstateRepository = realEstateRepository;
        this.jewelryRepository = jewelryRepository;
        this.furnitureRepository = furnitureRepository;
        this.clothesRepository = clothesRepository;
        this.sportEquipmentRepository = sportEquipmentRepository;
        this.buildingEquipmentRepository = buildingEquipmentRepository;
        this.medicalEquipmentRepository = medicalEquipmentRepository;
        this.otherItemRepository = otherItemRepository;
    }

    public List<Auction> findCarsForLots(List<Lot> lots) {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<Car> foundItem = carRepository.findByLotId(lot.getId());
            foundItem.ifPresent(auction::setCar);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findEstateForLots(List<Lot> lots) {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<RealEstate> foundItem = realEstateRepository.findByLotId(lot.getId());
            foundItem.ifPresent(auction::setRealEstate);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findJewelryForLots(List<Lot> lots) {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<Jewelry> foundItem = jewelryRepository.findByLotId(lot.getId());
            foundItem.ifPresent(auction::setJewelry);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findFurnitureForLots(List<Lot> lots) {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<Furniture> foundItem = furnitureRepository.findByLotId(lot.getId());
            foundItem.ifPresent(auction::setFurniture);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findClothesForLots(List<Lot> lots) {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<Clothes> foundItem = clothesRepository.findByLotId(lot.getId());
            foundItem.ifPresent(auction::setClothes);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findBuildingEquipmentForLots(List<Lot> lots) {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<BuildingEquipment> foundItem = buildingEquipmentRepository.findByLotId(lot.getId());
            foundItem.ifPresent(auction::setBuildingEquipment);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findSportEquipmentForLots(List<Lot> lots) {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<SportEquipment> foundItem = sportEquipmentRepository.findByLotId(lot.getId());
            foundItem.ifPresent(auction::setSportEquipment);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findMedicalEquipmentForLots(List<Lot> lots) {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<MedicalEquipment> foundItem = medicalEquipmentRepository.findByLotId(lot.getId());
            foundItem.ifPresent(auction::setMedicalEquipment);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findOtherItemsForLots(List<Lot> lots) {
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<OtherItem> foundItem = otherItemRepository.findByLotId(lot.getId());
            foundItem.ifPresent(auction::setOtherItem);
            auctions.add(auction);
        }
        return auctions;
    }

}
