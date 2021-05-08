package cz.czechitas.java2webapps.lekce6.controller.alkohol;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 */
public class AlkoholForm {
  @NotBlank
  private String zbozi;
  @NotNull
  private Objem objem;
//  hodnota ve formláři se dá přednastavit
//  private Objem objem = Objem.OBJEM_5L;
  @NotBlank
  private String jmeno;
  //  hodnota ve formláři se dá přednastavit
//  private String jmeno = "Petr Novák";
  @NotNull
  @Min(1)
  @Max(150)
//  Velký Integer se používá proto, aby se mohlo zadat null a pak se to zachytit pomocí @NotNull
//  V případě použití malého int by se při nevyplnění pole automaticky odeslala 0. Tato chyba by se teoreticky
//  zachytila pomocí @Min(1), ale je lepší použít Integer.
  private Integer vek;
  @Email
  @NotBlank
  private String email;
  @AssertTrue
  private boolean obchodniPodminky;
  private boolean newsletter;

  public String getZbozi() {
    return zbozi;
  }

  public void setZbozi(String zbozi) {
    this.zbozi = zbozi;
  }

  public Objem getObjem() {
    return objem;
  }

  public void setObjem(Objem objem) {
    this.objem = objem;
  }

  public String getJmeno() {
    return jmeno;
  }

  public void setJmeno(String jmeno) {
    this.jmeno = jmeno;
  }

  public Integer getVek() {
    return vek;
  }

  public void setVek(Integer vek) {
    this.vek = vek;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isObchodniPodminky() {
    return obchodniPodminky;
  }

  public void setObchodniPodminky(boolean obchodniPodminky) {
    this.obchodniPodminky = obchodniPodminky;
  }

  public boolean isNewsletter() {
    return newsletter;
  }

  public void setNewsletter(boolean newsletter) {
    this.newsletter = newsletter;
  }
}
