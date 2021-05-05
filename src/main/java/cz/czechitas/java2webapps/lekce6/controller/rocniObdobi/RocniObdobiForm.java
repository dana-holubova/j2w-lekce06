package cz.czechitas.java2webapps.lekce6.controller.rocniObdobi;

import java.util.EnumSet;

/**
 *
 */
public class RocniObdobiForm {
  private EnumSet<RocniObdobiEnum> oblibena;

  public EnumSet<RocniObdobiEnum> getOblibena() {
    return oblibena;
  }

  public void setOblibena(EnumSet<RocniObdobiEnum> oblibena) {
    this.oblibena = oblibena;
  }
}
