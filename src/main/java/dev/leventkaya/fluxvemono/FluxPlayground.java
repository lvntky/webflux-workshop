package dev.leventkaya.fluxvemono;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.List;

public class FluxPlayground {
    @Test
    public void createFluxObject() {
        Flux<String> company = Flux.fromIterable(List.of("CodeFirst", "Yazilim", "Teknolojileri")).log();
        company.subscribe(data -> {
            System.out.println("Flux -> data = " + data);
        });
    }
}
