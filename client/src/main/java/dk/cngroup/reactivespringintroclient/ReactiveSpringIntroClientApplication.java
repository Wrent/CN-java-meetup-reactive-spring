package dk.cngroup.reactivespringintroclient;

import dk.cngroup.reactivespringintroclient.model.Consumption;
import dk.cngroup.reactivespringintroclient.model.JavaDev;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveSpringIntroClientApplication implements CommandLineRunner {

  @Bean
  WebClient client() {
    return WebClient.create("http://localhost:8080");
  }

  @Override
  public void run(String... args) {
    client().get()
        .uri("devs")
        .retrieve()
        .bodyToFlux(JavaDev.class)
        .filter(javaDev -> javaDev.getName().equals("Dominik"))
        .flatMap(javaDev ->
            client().get().uri("devs/{id}/consumption", javaDev.getId())
                .retrieve()
                .bodyToFlux(Consumption.class))
        .subscribe(System.out::println);
  }

  public static void main(String[] args) {
    SpringApplication.run(ReactiveSpringIntroClientApplication.class, args);
  }
}
