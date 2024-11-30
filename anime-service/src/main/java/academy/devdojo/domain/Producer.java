package academy.devdojo.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Producer {
    private Long id;
    @JsonProperty("name")
    private String name;
    private static List<Producer> producer = new ArrayList<>();

    static {
        var mapa = new Producer(1L, "Mapa");
        var kyotoAnimation = new Producer(2L, "Kyoto Animation");
        var madhouse = new Producer(3L, "madhouse");
        producer.addAll(List.of(mapa, kyotoAnimation, madhouse));
    }

    public static List<Producer> getProducers() {
        return producer;
    }
}
