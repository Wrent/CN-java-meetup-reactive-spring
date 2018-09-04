package dk.cngroup.reactivespringintro;

import dk.cngroup.reactivespringintro.model.JavaDev;
import dk.cngroup.reactivespringintro.repository.JavaMeetupRepository;
import java.util.stream.Stream;
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
    this.repository
        .deleteAll()
        .subscribe(null, null, () ->
            Stream.of("Adam", "Dominik", "Martin", "Jirka")
            .map(JavaDev::new)
            .forEach(dev -> repository.save(dev).subscribe(System.out::println)));
  }
}
