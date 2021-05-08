package cz.czechitas.java2webapps.lekce6.controller.rocniObdobi;

import java.util.EnumSet;

/**
 *
 */
public class RocniObdobiForm {
  // Pokud se odešle proměnná z input type checkbox, tak Spring umí namapovat odeslané hodnoty do EnumSet.
  private EnumSet<RocniObdobiEnum> oblibena;

  public EnumSet<RocniObdobiEnum> getOblibena() {
    return oblibena;
  }

  public void setOblibena(EnumSet<RocniObdobiEnum> oblibena) {
    this.oblibena = oblibena;
  }
}
