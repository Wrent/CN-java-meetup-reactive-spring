package dk.cngroup.reactivespringintro.service;

import static dk.cngroup.reactivespringintro.ReactiveSpringIntroApplication.randomId;

import dk.cngroup.reactivespringintro.model.Consumption;
import dk.cngroup.reactivespringintro.model.JavaDev;
import dk.cngroup.reactivespringintro.model.Substance;
import dk.cngroup.reactivespringintro.repository.JavaMeetupRepository;
import java.time.Duration;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class JavaMeetupService {

  private final JavaMeetupRepository repository;

  public JavaMeetupService(JavaMeetupRepository repository) {
    this.repository = repository;
  }

  public Flux<Consumption> consumptionForDev(JavaDev dev) {
    return
        Flux.interval(Duration.ofSeconds(1))
        .map(second -> new Consumption(Substance.random(), dev.getName()));
  }

  public Mono<JavaDev> byId(String id) {
    return repository.findById(id);
  }

  public Flux<JavaDev> developers() {
    return repository.findAll();
  }
}
