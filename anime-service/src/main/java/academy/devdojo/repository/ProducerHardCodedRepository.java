package academy.devdojo.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import academy.devdojo.domain.Producer;
import external.Connection;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ProducerHardCodedRepository {
    private final static List<Producer> PRODUCERS = new ArrayList<>();
    @Qualifier(value = "connectionMongoDB")
    private final Connection connection;

    static {
        var mapa = Producer.builder().id(1L).name("Mapa").createdAt(LocalDateTime.now()).build();
        var kyotoAnimation = Producer.builder().id(2L).name("Kyoto Animation").createdAt(LocalDateTime.now()).build();
        var madhouse = Producer.builder().id(3L).name("madhouse").createdAt(LocalDateTime.now()).build();
        PRODUCERS.addAll(List.of(mapa, kyotoAnimation, madhouse));
    }

    public List<Producer> findAll() {
        return PRODUCERS;
    }

    public Optional<Producer> findById(Long id) {
        return PRODUCERS.stream().filter(producer -> producer.getId().equals(id)).findFirst();
    }

    public List<Producer> findByName(String name) {
        log.debug(connection);
        return PRODUCERS.stream().filter(producer -> producer.getName().equalsIgnoreCase(name)).toList();
    }

    public Producer save(Producer producer) {
        PRODUCERS.add(producer);
        return producer;
    }

    public void delete(Producer producer) {
        PRODUCERS.remove(producer);
    }

    public void update(Producer producer) {
        delete(producer);
        save(producer);
    }
}
