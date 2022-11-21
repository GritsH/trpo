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

    public List<Auction> getAllAuctions(List<Lot> lots) {
        return auctionDao.findAllAuctions(lots);
    }
    public List<Auction> getCarAuctions(List<Lot> lots){
        return auctionDao.findAllCars(lots);
    }
    public List<Auction> getEstateAuctions(List<Lot> lots){
        return auctionDao.findAllEstate(lots);
    }

    public List<Auction> getJewelryAuctions(List<Lot> lots){
        return auctionDao.findAllJewelry(lots);
    }

    public List<Auction> getClothesAuctions(List<Lot> lots){
        return auctionDao.findAllClothes(lots);
    }

    public List<Auction> getFurnitureAuctions(List<Lot> lots){
        return auctionDao.findAllFurniture(lots);
    }

    public List<Auction> getBuildingEquipmentAuctions(List<Lot> lots){
        return auctionDao.findAllBuildingEquipment(lots);
    }

    public List<Auction> getSportEquipmentAuctions(List<Lot> lots){
        return auctionDao.findAllSportEquipment(lots);
    }

    public List<Auction> getMedicalEquipmentAuctions(List<Lot> lots){
        return auctionDao.findAllMedicalEquipment(lots);
    }

    public List<Auction> getOtherAuctions(List<Lot> lots){
        return auctionDao.findAllOther(lots);
    }
}
