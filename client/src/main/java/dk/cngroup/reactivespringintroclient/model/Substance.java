package dk.cngroup.reactivespringintroclient.model;

import java.util.Random;

public enum Substance {
  COKE, BEER, SAUSAGE, STEAK;

  public static Substance random() {
    return Substance.values()[new Random().nextInt(Substance.values().length)];
  }
}
