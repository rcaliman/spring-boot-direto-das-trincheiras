package academy.devdojo.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Producer {
    private Long id;
    @JsonProperty("name")
    private String name;
    private LocalDateTime createdAt;
    private static List<Producer> producer = new ArrayList<>();

    static {
        var mapa = Producer.builder().id(1L).name("Mapa").createdAt(LocalDateTime.now()).build();
        var kyotoAnimation = Producer.builder().id(2L).name("Kyoto Animation").createdAt(LocalDateTime.now()).build();
        var madhouse = Producer.builder().id(3L).name("madhouse").createdAt(LocalDateTime.now()).build();
        producer.addAll(List.of(mapa, kyotoAnimation, madhouse));
    }

    public static List<Producer> getProducers() {
        return producer;
    }
}
