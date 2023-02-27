package dk.springpractice.msscbeerservice.bootstrap;

import dk.springpractice.msscbeerservice.BeerRepository;
import dk.springpractice.msscbeerservice.domain.Beer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.SchemaOutputResolver;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    public void loadBeerObjects(){
        if(beerRepository.count()==0){

            beerRepository.save(Beer.builder().beerName("Coors Light")
                    .beerStyle("IPA").quantityToBrew(200).upc(3370L)
                    .price(new BigDecimal(12.95)).minOnHand(12).build());

            beerRepository.save(Beer.builder().beerName("Bud Light")
                    .beerStyle("PALE ALE").quantityToBrew(201).upc(3371L)
                    .price(new BigDecimal(11.95)).minOnHand(12).build());

        }
        System.out.println("Loaded beers: " + beerRepository.count());

    }
}
