package dk.cngroup.reactivespringintro.controller;

import dk.cngroup.reactivespringintro.model.Consumption;
import dk.cngroup.reactivespringintro.model.JavaDev;
import dk.cngroup.reactivespringintro.service.JavaMeetupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class JavaMeetupController {

  private final JavaMeetupService service;

  public JavaMeetupController(
      JavaMeetupService service) {
    this.service = service;
  }

  @GetMapping("devs")
  public Flux<JavaDev> getDevs() {
    return service.developers();
  }

  @GetMapping("devs/{id}")
  public Mono<JavaDev> getDev(@PathVariable("id") String id) {
    return service.byId(id);
  }

  @GetMapping("devs/{id}/consumption")
  public Flux<Consumption> getConsumption(@PathVariable("id") String id) {
    return service.consumptionForDev(id);
  }
}
