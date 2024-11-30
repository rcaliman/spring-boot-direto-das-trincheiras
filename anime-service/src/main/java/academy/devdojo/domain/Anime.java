package academy.devdojo.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Anime {
    private Long id;
    private String name;
    private static List<Anime> animes = new ArrayList<>();

    static {
        var ninjaKamui = new Anime(1L, "Dragon Ball Z");
        var kaijuu = new Anime(2L, "Kaijuu-8gou");
        var kimetsuNoYaiba = new Anime(3L, "Kimetsu NO Yaiba");
        animes.addAll(List.of(ninjaKamui, kaijuu, kimetsuNoYaiba));
    }

    public static List<Anime> getAnimes() {
        return animes;
    }
}
