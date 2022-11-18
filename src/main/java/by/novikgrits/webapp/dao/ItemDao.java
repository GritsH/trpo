package by.novikgrits.webapp.dao;

import by.novikgrits.webapp.model.Car;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.RealEstate;
import by.novikgrits.webapp.repository.CarRepository;
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

    public ItemDao(LotRepository lotRepository, CarRepository carRepository, RealEstateRepository realEstateRepository) {
        this.lotRepository = lotRepository;
        this.carRepository = carRepository;
        this.realEstateRepository = realEstateRepository;
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
    public void removeCar(Integer lotId){
        carRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }

    @Transactional
    public void removeRealEstate(Integer lotId){
        realEstateRepository.deleteByLotId(lotId);
        lotRepository.deleteById(lotId);
    }
}
