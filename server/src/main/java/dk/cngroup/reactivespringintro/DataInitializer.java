package dk.cngroup.reactivespringintro;

import dk.cngroup.reactivespringintro.model.JavaDev;
import dk.cngroup.reactivespringintro.repository.JavaMeetupRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class DataInitializer {

  private final JavaMeetupRepository repository;

  DataInitializer(JavaMeetupRepository repository) {
    this.repository = repository;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void run(ApplicationReadyEvent evt) {
    System.out.println("started");

    this.repository
        .deleteAll()
        .thenMany(
            Flux
                .just("Adam", "Dominik", "Martin", "Jirka")
                .map(name -> this.repository.save(new JavaDev(name)))
        ).subscribe(System.out::println, null,
        () -> this.repository.findAll().subscribe(System.out::println));
  }
}
