package dk.cngroup.reactivespringintro.model;

import static dk.cngroup.reactivespringintro.ReactiveSpringIntroApplication.randomId;

public class Consumption {

  private String id;
  private Substance substance;
  private String javaDevId;

  public Consumption(Substance substance,
      String javaDevId) {
    this.id = randomId();
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

  @Override
  public String toString() {
    return "Consumption{" +
        "id='" + id + '\'' +
        ", substance=" + substance +
        ", javaDevId='" + javaDevId + '\'' +
        '}';
  }
}
