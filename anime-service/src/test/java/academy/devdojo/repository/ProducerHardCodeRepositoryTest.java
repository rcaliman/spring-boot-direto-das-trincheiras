package academy.devdojo.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import academy.devdojo.domain.Producer;

@ExtendWith(MockitoExtension.class)
public class ProducerHardCodeRepositoryTest {
    @InjectMocks
    private ProducerHardCodedRepository repository;

    @Mock
    private ProducerData producerData;
    private final List<Producer> producersList = new ArrayList<>();

    @BeforeEach
    void init() {
        var ufotable = Producer.builder().id(1L).name("Ufotable").createdAt(LocalDateTime.now()).build();
        var witStudio = Producer.builder().id(2L).name("Wit Studio").createdAt(LocalDateTime.now()).build();
        var studioGhibli = Producer.builder().id(3L).name("Studio Ghibli").createdAt(LocalDateTime.now()).build();
        producersList.addAll(List.of(ufotable, witStudio, studioGhibli));
    }

    @Test
    @DisplayName("findAll returns a list with all producers")
    void findAll_ReturnsAllProducers_WhenSuccesfull() {
        BDDMockito.when(producerData.getProducers()).thenReturn(producersList);
        var producers = repository.findAll();
        Assertions.assertThat(producers).isNotNull().hasSize(producers.size());
    };
}
