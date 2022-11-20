package by.novikgrits.webapp.dao;

import by.novikgrits.webapp.model.*;
import by.novikgrits.webapp.repository.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Component
public class ItemDao {
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

    public ItemDao(LotRepository lotRepository, CarRepository carRepository, RealEstateRepository realEstateRepository, JewelryRepository jewelryRepository, FurnitureRepository furnitureRepository, ClothesRepository clothesRepository, SportEquipmentRepository sportEquipmentRepository, BuildingEquipmentRepository buildingEquipmentRepository, MedicalEquipmentRepository medicalEquipmentRepository, OtherItemRepository otherItemRepository) {
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

    @Transactional
    public void registerItem(Car car, Lot lot) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        car.setLotId(id);
        carRepository.save(car);
    }

    @Transactional
    public void registerItem(RealEstate realEstate, Lot lot) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        realEstate.setLotId(id);
        realEstateRepository.save(realEstate);
    }

    @Transactional
    public void registerItem(Clothes clothes, Lot lot) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        clothes.setLotId(id);
        clothesRepository.save(clothes);
    }

    @Transactional
    public void registerItem(SportEquipment sportEquipment, Lot lot) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        sportEquipment.setLotId(id);
        sportEquipmentRepository.save(sportEquipment);
    }

    @Transactional
    public void registerItem(BuildingEquipment buildingEquipment, Lot lot) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        buildingEquipment.setLotId(id);
        buildingEquipmentRepository.save(buildingEquipment);
    }

    @Transactional
    public void registerItem(MedicalEquipment medicalEquipment, Lot lot) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        medicalEquipment.setLotId(id);
        medicalEquipmentRepository.save(medicalEquipment);
    }

    @Transactional
    public void registerItem(OtherItem otherItem, Lot lot) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        otherItem.setLotId(id);
        otherItemRepository.save(otherItem);
    }

    @Transactional
    public void registerItem(Furniture furniture, Lot lot) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        furniture.setLotId(id);
        furnitureRepository.save(furniture);
    }

    @Transactional
    public void registerItem(Jewelry jewelry, Lot lot) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        jewelry.setLotId(id);
        jewelryRepository.save(jewelry);
    }

    @Transactional
    public void removeCar(Integer lotId) {
        carRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeRealEstate(Integer lotId) {
        realEstateRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeJewelry(Integer lotId) {
        jewelryRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeFurniture(Integer lotId) {
        furnitureRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeClothes(Integer lotId) {
        clothesRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeSportEquipment(Integer lotId) {
        sportEquipmentRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeBuildingEquipment(Integer lotId) {
        buildingEquipmentRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeMedicalEquipment(Integer lotId) {
        medicalEquipmentRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeOtherItem(Integer lotId) {
        otherItemRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }
}
