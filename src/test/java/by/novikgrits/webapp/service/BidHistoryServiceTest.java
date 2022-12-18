package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.BidHistory;
import by.novikgrits.webapp.repository.BidHistoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BidHistoryServiceTest {
    @InjectMocks
    private BidHistoryService bidHistoryService;

    @Mock
    private BidHistoryRepository bidHistoryRepository;

    @DisplayName("should add history")
    @Test
    void addHistory() {
        BidHistory history = new BidHistory(1, "email", 1.0, "2022-12-07T00:00:00");

        bidHistoryService.addHistory(history);

        verify(bidHistoryRepository).save(history);
        verifyNoMoreInteractions(bidHistoryRepository);
    }

    @DisplayName("should find history by id")
    @Test
    void findById() {
        BidHistory mockedHistory = mock(BidHistory.class);

        when(bidHistoryRepository.findById(1)).thenReturn(Optional.of(mockedHistory));

        Optional<BidHistory> result = bidHistoryService.findById(1);

        assertEquals(mockedHistory, result.get());

        verify(bidHistoryRepository).findById(1);
        verifyNoMoreInteractions(bidHistoryRepository);
    }

    @DisplayName("should find all histories")
    @Test
    void findAll() {
        List<BidHistory> repositoryResponse = new ArrayList<>();
        BidHistory mockedHistory = mock(BidHistory.class);
        repositoryResponse.add(mockedHistory);

        when(bidHistoryRepository.findAll()).thenReturn(repositoryResponse);

        List<BidHistory> result = bidHistoryService.findAll();

        assertEquals(mockedHistory, result.get(0));

        verify(bidHistoryRepository).findAll();
        verifyNoMoreInteractions(bidHistoryRepository);
    }

    @Test
    void findByBidderEmailAndLotId() {
        List<BidHistory> repositoryResponse = new ArrayList<>();
        BidHistory mockedHistory = mock(BidHistory.class);
        repositoryResponse.add(mockedHistory);

        when(bidHistoryRepository.findAllByBidderIdAndLotId("email", 1)).thenReturn(repositoryResponse);

        List<BidHistory> result = bidHistoryService.findByBidderIdAndLotId("email", 1);

        assertEquals(mockedHistory, result.get(0));

        verify(bidHistoryRepository).findAllByBidderIdAndLotId("email", 1);
        verifyNoMoreInteractions(bidHistoryRepository);
    }

    @Test
    void findByBidderEmail() {
        List<BidHistory> repositoryResponse = new ArrayList<>();
        BidHistory mockedHistory = mock(BidHistory.class);
        repositoryResponse.add(mockedHistory);

        when(bidHistoryRepository.findAllByBidderId("email")).thenReturn(repositoryResponse);

        List<BidHistory> result = bidHistoryService.findByBidderId("email");

        assertEquals(mockedHistory, result.get(0));

        verify(bidHistoryRepository).findAllByBidderId("email");
        verifyNoMoreInteractions(bidHistoryRepository);
    }

    @Test
    void findByLotId() {
        List<BidHistory> repositoryResponse = new ArrayList<>();
        BidHistory mockedHistory = mock(BidHistory.class);
        repositoryResponse.add(mockedHistory);

        when(bidHistoryRepository.findAllByLotId(1)).thenReturn(repositoryResponse);

        List<BidHistory> result = bidHistoryService.findByLotId(1);

        assertEquals(mockedHistory, result.get(0));

        verify(bidHistoryRepository).findAllByLotId(1);
        verifyNoMoreInteractions(bidHistoryRepository);
    }
}