package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.Lot;
import by.novikgrits.webapp.model.item.ItemType;
import by.novikgrits.webapp.repository.LotRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LotServiceTest {
    @InjectMocks
    private LotService lotService;
    @Mock
    private LotRepository lotRepository;

    @DisplayName("should add new lot")
    @Test
    void addLot() {
        Lot lot = new Lot(1, LocalDate.now(), LocalDate.now(),
                1.0, 1.0, 1.0, 1, "dedede", "info", ItemType.CLOTHES);
        GeneratedKeyHolder key = mock(GeneratedKeyHolder.class);
        lotService.save(lot, key);

        verify(lotRepository).save(lot, key);
        verifyNoMoreInteractions(lotRepository);
    }

    @DisplayName("should find lot by id")
    @Test
    void findById() {
        Lot mockedLot = mock(Lot.class);

        when(lotRepository.findById(1)).thenReturn(Optional.of(mockedLot));

        Optional<Lot> result = lotService.findById(1);

        assertEquals(mockedLot, result.get());

        verify(lotRepository).findById(1);
        verifyNoMoreInteractions(lotRepository);
    }

    @DisplayName("should delete lot by id")
    @Test
    void deleteById() {
        lotService.deleteById(0);

        verify(lotRepository).deleteById(0);
        verifyNoMoreInteractions(lotRepository);
    }

    @DisplayName("should final all lots")
    @Test
    void findAll() {
        List<Lot> repositoryResponse = new ArrayList<>();
        Lot mockedLot = mock(Lot.class);
        repositoryResponse.add(mockedLot);

        when(lotRepository.findAll()).thenReturn(repositoryResponse);

        List<Lot> result = lotService.findAll();

        assertEquals(mockedLot, result.get(0));

        verify(lotRepository).findAll();
        verifyNoMoreInteractions(lotRepository);
    }
}