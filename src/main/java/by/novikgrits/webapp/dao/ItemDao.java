package by.novikgrits.webapp.dao;

import by.novikgrits.webapp.model.Car;
import by.novikgrits.webapp.model.Jewelry;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.RealEstate;
import by.novikgrits.webapp.repository.CarRepository;
import by.novikgrits.webapp.repository.JewelryRepository;
import by.novikgrits.webapp.repository.LotRepository;
import by.novikgrits.webapp.repository.RealEstateRepository;
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

    public ItemDao(LotRepository lotRepository, CarRepository carRepository, RealEstateRepository realEstateRepository, JewelryRepository jewelryRepository) {
        this.lotRepository = lotRepository;
        this.carRepository = carRepository;
        this.realEstateRepository = realEstateRepository;
        this.jewelryRepository = jewelryRepository;
    }

    @Transactional
    public void registerItem(Car car, Lot lot){
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        car.setLotId(id);
        carRepository.save(car);
    }

    @Transactional
    public void registerItem(RealEstate realEstate, Lot lot){
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        realEstate.setLotId(id);
        realEstateRepository.save(realEstate);
    }

    @Transactional
    public void registerItem(Jewelry jewelry, Lot lot){
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        lotRepository.save(lot, generatedKeyHolder);

        Integer id = Objects.requireNonNull(generatedKeyHolder.getKey()).intValue();

        jewelry.setLotId(id);
        jewelryRepository.save(jewelry);
    }

    @Transactional
    public void removeCar(Integer lotId){
        carRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeRealEstate(Integer lotId){
        realEstateRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeJewelry(Integer lotId){
        jewelryRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }
}
