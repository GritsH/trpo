package by.novikgrits.webapp.service;

import by.novikgrits.webapp.dao.ItemDao;
import by.novikgrits.webapp.model.*;
import by.novikgrits.webapp.model.item.*;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemDao itemDao;

    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void register(Lot lot, Car car){
        itemDao.registerItem(car, lot);
    }

    public void register(Lot lot, RealEstate realEstate){
        itemDao.registerItem(realEstate, lot);
    }

    public void register(Lot lot, Clothes clothes){
        itemDao.registerItem(clothes, lot);
    }

    public void register(Lot lot, SportEquipment sportEquipment){
        itemDao.registerItem(sportEquipment, lot);
    }

    public void register(Lot lot, BuildingEquipment buildingEquipment){
        itemDao.registerItem(buildingEquipment, lot);
    }

    public void register(Lot lot, MedicalEquipment medicalEquipment){
        itemDao.registerItem(medicalEquipment, lot);
    }

    public void register(Lot lot, OtherItem otherItem){
        itemDao.registerItem(otherItem, lot);
    }

    public void register(Lot lot, Furniture furniture){
        itemDao.registerItem(furniture, lot);
    }

    public void register(Lot lot, Jewelry jewelry){
        itemDao.registerItem(jewelry, lot);
    }
}
