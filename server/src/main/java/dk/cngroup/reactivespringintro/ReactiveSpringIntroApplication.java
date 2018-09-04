package dk.cngroup.reactivespringintro;

import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveSpringIntroApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReactiveSpringIntroApplication.class, args);
  }

  public static String randomId() {
    return UUID.randomUUID().toString();
  }
}