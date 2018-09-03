package dk.cngroup.reactivespringintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SpringBootApplication
public class ReactiveSpringIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpringIntroApplication.class, args);
	}

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
	}

	public enum Substance {
		COKE, BEER, SAUSAGE, STEAK;
	}
}
