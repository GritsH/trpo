package by.novikgrits.webapp.service;

import by.novikgrits.webapp.dao.ItemDao;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.LotPhoto;
import by.novikgrits.webapp.model.item.*;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemDao itemDao;

    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void register(Lot lot, Car car, LotPhoto photo) {
        itemDao.registerItem(car, lot, photo);
    }

    public void register(Lot lot, RealEstate realEstate, LotPhoto photo) {
        itemDao.registerItem(realEstate, lot, photo);
    }

    public void register(Lot lot, Clothes clothes, LotPhoto photo) {
        itemDao.registerItem(clothes, lot, photo);
    }

    public void register(Lot lot, SportEquipment sportEquipment, LotPhoto photo) {
        itemDao.registerItem(sportEquipment, lot, photo);
    }

    public void register(Lot lot, BuildingEquipment buildingEquipment, LotPhoto photo) {
        itemDao.registerItem(buildingEquipment, lot, photo);
    }

    public void register(Lot lot, MedicalEquipment medicalEquipment, LotPhoto photo) {
        itemDao.registerItem(medicalEquipment, lot, photo);
    }

    public void register(Lot lot, OtherItem otherItem, LotPhoto photo) {
        itemDao.registerItem(otherItem, lot, photo);
    }

    public void register(Lot lot, Furniture furniture, LotPhoto photo) {
        itemDao.registerItem(furniture, lot, photo);
    }

    public void register(Lot lot, Jewelry jewelry, LotPhoto photo) {
        itemDao.registerItem(jewelry, lot, photo);
    }

    public void removeItem(Lot lot) {
        ItemType itemType = lot.getItemType();
        Integer lotId = lot.getId();
        switch (itemType) {
            case CAR -> itemDao.removeCar(lotId);
            case JEWELRY -> itemDao.removeJewelry(lotId);
            case OTHER -> itemDao.removeOtherItem(lotId);
            case CLOTHES -> itemDao.removeClothes(lotId);
            case FURNITURE -> itemDao.removeFurniture(lotId);
            case REAL_ESTATE -> itemDao.removeRealEstate(lotId);
            case SPORT_EQUIPMENT -> itemDao.removeSportEquipment(lotId);
            case MEDICAL_EQUIPMENT -> itemDao.removeMedicalEquipment(lotId);
            case BUILDING_EQUIPMENT -> itemDao.removeBuildingEquipment(lotId);
        }
    }
}
