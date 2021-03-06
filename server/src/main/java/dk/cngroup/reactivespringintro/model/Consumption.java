package dk.cngroup.reactivespringintro.model;

import static dk.cngroup.reactivespringintro.ReactiveSpringIntroApplication.randomId;

public class Consumption {

  private String id;
  private Substance substance;
  private String javaDev;

  public Consumption(Substance substance,
      String javaDevId) {
    this.id = randomId();
    this.substance = substance;
    this.javaDev = javaDevId;
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

  public String getJavaDev() {
    return javaDev;
  }

  public void setJavaDev(String javaDev) {
    this.javaDev = javaDev;
  }

  @Override
  public String toString() {
    return "Consumption{" +
        "id='" + id + '\'' +
        ", substance=" + substance +
        ", javaDev='" + javaDev + '\'' +
        '}';
  }
}
