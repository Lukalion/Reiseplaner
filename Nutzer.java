
public class Nutzer {
  
  public int ID;
  public String email;
  public String vorname;
  public String nachname;
  public int oeffentlich;
  
  public Nutzer(int id, String email, int o) {
    this.ID = id;
    this.email = email;
    this.oeffentlich = o;
    
  }
  public Nutzer() {
    
  }

}
