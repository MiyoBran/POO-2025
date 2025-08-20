package tp1.facultad;

/**
 * Clase que representa los datos personales de una persona: calle, ciudad, teléfono y mail.
 */
public class DatosPersonales {
  private String calle;
  private String ciudad;
  private String telefono;
  private String mail;

  /**
   * Constructor que inicializa los atributos de la clase.
   */
  public DatosPersonales(String calle, String ciudad, String telefono, String mail) {
    this.calle = calle;
    this.ciudad = ciudad;
    this.telefono = telefono;
    this.mail = mail;
  }
  // Setters y Getters de los atributos.
  public String getCalle() {
    return calle;
  }
  public void setCalle(String calle) {
    this.calle = calle;
  }
  public String getCiudad() {
    return ciudad;
  }
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  public String getMail() {
    return mail;
  }
  public void setMail(String mail) {
    this.mail = mail;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((calle == null) ? 0 : calle.hashCode());
    result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
    result = prime * result + ((mail == null) ? 0 : mail.hashCode());
    result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DatosPersonales other = (DatosPersonales) obj;
    if (calle == null) {
      if (other.calle != null)
        return false;
    } else if (!calle.equals(other.calle))
      return false;
    if (ciudad == null) {
      if (other.ciudad != null)
        return false;
    } else if (!ciudad.equals(other.ciudad))
      return false;
    if (telefono == null) {
      if (other.telefono != null)
        return false;
    } else if (!telefono.equals(other.telefono))
      return false;
    if (mail == null) {
      if (other.mail != null)
        return false;
    } else if (!mail.equals(other.mail))
      return false;
    return true;
  }

  /**
   * Devuelve una representación en texto de los datos personales.
   */
  @Override
  public String toString() {
    return "DatosPersonales{" +
      "calle='" + calle + '\'' +
      ", ciudad='" + ciudad + '\'' +
      ", telefono='" + telefono + '\'' +
      ", mail='" + mail + '\'' +
      '}';
  }
}
