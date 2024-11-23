package academy.devdojo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/animes")
public class AnimeController {
    
    @GetMapping
    public List<String> listAll() {
        return List.of("Akira", "Naruto", "Atack on Titan");
    }
}
