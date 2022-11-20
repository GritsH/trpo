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

    public AuctionRepository(LotRepository lotRepository, CarRepository carRepository, RealEstateRepository realEstateRepository, JewelryRepository jewelryRepository) {
        this.lotRepository = lotRepository;
        this.carRepository = carRepository;
        this.realEstateRepository = realEstateRepository;
        this.jewelryRepository = jewelryRepository;
    }

    public List<Auction> findCarsForLots(List<Lot> lots){
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<Car> foundCar = carRepository.findByLotId(lot.getId());
            foundCar.ifPresent(auction::setCar);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findEstateForLots(List<Lot> lots){
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<RealEstate> foundEstate = realEstateRepository.findByLotId(lot.getId());
            foundEstate.ifPresent(auction::setRealEstate);
            auctions.add(auction);
        }
        return auctions;
    }

    public List<Auction> findJewelryForLots(List<Lot> lots){
        List<Auction> auctions = new ArrayList<>();
        for (Lot lot : lots) {
            Auction auction = new Auction();
            auction.setLot(lot);
            Optional<Jewelry> foundJewelry = jewelryRepository.findByLotId(lot.getId());
            foundJewelry.ifPresent(auction::setJewelry);
            auctions.add(auction);
        }
        return auctions;
    }
}
