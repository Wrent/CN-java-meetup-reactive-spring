package dk.cngroup.reactivespringintro.model;

import static dk.cngroup.reactivespringintro.ReactiveSpringIntroApplication.randomId;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class JavaDev {

  @Id
  private String id;
  private String name;

  public JavaDev(String name) {
    this.id = randomId();
    this.name = name;
  }

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

  @Override
  public String toString() {
    return "JavaDev{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
