package polaczenie;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "Nauczyciele")
public class Nauczyciele {
 private Integer id;
 private String imie;
 private String nazwisko;
 private String uwagi;
 private String przedmiot;
 private Integer rok;
 private Integer sala;
 
 public Nauczyciele() {
 }
 
 public Nauczyciele(Integer id, String imie, String nazwisko, String uwagi, String przedmiot, Integer rok, Integer sala) {
     this.id = id;
     this.imie = imie;
     this.nazwisko = nazwisko;
     this.uwagi = uwagi;
     this.przedmiot = przedmiot;
     this.rok = rok;
     this.sala = sala;
 }
 
 @Id
 @Column(name = "ID")
 public Integer getId() {
     return id;
 }
 
 public void setId(Integer id) {
     this.id = id;
 }
 
 @Column(name = "Imie", nullable = false)
 public String getImie() {
     return imie;
 }
 
 public void setImie(String imie) {
     this.imie = imie;
 }
 
 @Column(name = "Nazwisko", nullable = false)
 public String getNazwisko() {
     return nazwisko;
 }
 
 public void setNazwisko(String nazwisko) {
     this.nazwisko = nazwisko; }
     
@Column(name = "Uwagi")
     public String getUwagi() {
         return uwagi;
     }
     
     public void setUwagi(String uwagi) {
         this.uwagi = uwagi;
     }
     
     @Column(name = "Przedmioty")
     public String getPrzedmiot() {
         return przedmiot;
     }
     
     public void setPrzedmiot(String uwagi) {
         this.uwagi = uwagi;
     }
     
      @Column(name = "Rok", nullable = false)
     public Integer getRok() {
         return rok;
     }
     
     public void setRok(Integer rok) {
         this.rok = rok;
     }
     
     @Column(name = "Sala", nullable = false)
     public Integer getSala() {
         return sala;
     }
     
     public void setSaa(Integer sala) {
         this.sala = sala;
     }
     
     
     
 
}