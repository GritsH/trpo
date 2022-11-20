package by.novikgrits.webapp.dao;

import by.novikgrits.webapp.repository.CarRepository;
import by.novikgrits.webapp.repository.LotRepository;
import by.novikgrits.webapp.repository.RealEstateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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