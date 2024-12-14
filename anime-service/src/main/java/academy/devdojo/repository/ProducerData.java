package academy.devdojo.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import academy.devdojo.domain.Producer;

@Component
public class ProducerData {
    private final List<Producer> producers = new ArrayList<>();

    {
        var mapa = Producer.builder().id(1L).name("Mapa").createdAt(LocalDateTime.now()).build();
        var kyotoAnimation = Producer.builder().id(2L).name("Kyoto Animation").createdAt(LocalDateTime.now()).build();
        var madhouse = Producer.builder().id(3L).name("madhouse").createdAt(LocalDateTime.now()).build();
        producers.addAll(List.of(mapa, kyotoAnimation, madhouse));
    }

    public List<Producer> getProducers() {
        return producers;
    }
    
}
