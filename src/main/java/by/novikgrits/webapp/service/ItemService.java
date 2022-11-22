package by.novikgrits.webapp.service;

import by.novikgrits.webapp.dao.ItemDao;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.item.*;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemDao itemDao;

    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void register(Lot lot, Car car) {
        itemDao.registerItem(car, lot);
    }

    public void register(Lot lot, RealEstate realEstate) {
        itemDao.registerItem(realEstate, lot);
    }

    public void register(Lot lot, Clothes clothes) {
        itemDao.registerItem(clothes, lot);
    }

    public void register(Lot lot, SportEquipment sportEquipment) {
        itemDao.registerItem(sportEquipment, lot);
    }

    public void register(Lot lot, BuildingEquipment buildingEquipment) {
        itemDao.registerItem(buildingEquipment, lot);
    }

    public void register(Lot lot, MedicalEquipment medicalEquipment) {
        itemDao.registerItem(medicalEquipment, lot);
    }

    public void register(Lot lot, OtherItem otherItem) {
        itemDao.registerItem(otherItem, lot);
    }

    public void register(Lot lot, Furniture furniture) {
        itemDao.registerItem(furniture, lot);
    }

    public void register(Lot lot, Jewelry jewelry) {
        itemDao.registerItem(jewelry, lot);
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
