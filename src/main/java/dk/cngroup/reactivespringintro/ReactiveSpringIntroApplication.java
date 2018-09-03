package dk.cngroup.reactivespringintro;

import java.time.Duration;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ReactiveSpringIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpringIntroApplication.class, args);
	}

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

	@Service
	public class JavaMeetupService {
		private final JavaMeetupRepository repository;

		public JavaMeetupService(JavaMeetupRepository repository) {
			this.repository = repository;
		}

		public Flux<Consumption> consumptionForDev(String id) {
			return Flux.interval(Duration.ofSeconds(1))
					.map(second -> new Consumption(randomId(), Substance.random(), id));
		}

		public Mono<JavaDev> byId(String id) {
			return repository.findById(id);
		}

		public Flux<JavaDev> developers() {
				return repository.findAll();
		}
	}

	private String randomId() {
		return UUID.randomUUID().toString();
	}

	interface JavaMeetupRepository extends ReactiveMongoRepository<JavaDev, String> {}


	@Document
	public class JavaDev {
		@Id
		private String id;
		private String name;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	@Document
	public class Consumption {
		@Id
		private String id;
		private Substance substance;
		private String javaDevId;

		public Consumption(String id,
				Substance substance,
				String javaDevId) {
			this.id = id;
			this.substance = substance;
			this.javaDevId = javaDevId;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Substance getSubstance() {
			return substance;
		}

		public void setSubstance(
				Substance substance) {
			this.substance = substance;
		}

		public String getJavaDevId() {
			return javaDevId;
		}

		public void setJavaDevId(String javaDevId) {
			this.javaDevId = javaDevId;
		}
	}

	public enum Substance {
		COKE, BEER, SAUSAGE, STEAK;

		public static Substance random() {
			return null;
		}
	}
}
