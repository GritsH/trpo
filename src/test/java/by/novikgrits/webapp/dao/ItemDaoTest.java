package by.novikgrits.webapp.dao;

import by.novikgrits.webapp.model.Car;
import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.repository.CarRepository;
import by.novikgrits.webapp.repository.LotRepository;
import by.novikgrits.webapp.repository.RealEstateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ItemDaoTest {
    @InjectMocks
    private ItemDao itemDao;

    @Mock
    private LotRepository lotRepository;
    @Mock
    private CarRepository carRepository;
    @Mock
    private RealEstateRepository realEstateRepository;

    @Test
    void createLot() {

    }
}