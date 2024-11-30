package academy.devdojo.controllers;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import academy.devdojo.domain.Producer;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/producers")
@Slf4j
public class ProducerController {
    
    @GetMapping
    public List<Producer> listAll(@RequestParam(required = false) String name) {
       var producers = Producer.getProducers();
       if (name == null) return producers;

       return producers.stream().filter(producer -> producer.getName().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("{id}")
    public Producer findById(@PathVariable Long id) {
        return Producer.getProducers()
            .stream()
            .filter(producer -> producer.getId().equals(id))
            .findFirst().orElse(null);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "x-api-key")
    public Producer save(@RequestBody Producer producer, @RequestHeader HttpHeaders headers) {
        log.info("{}", headers);
        producer.setId(ThreadLocalRandom.current().nextLong(100_000));
        Producer.getProducers().add(producer);
        return producer;
    }
}
