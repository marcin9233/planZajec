package polaczenie;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "Uczniowie")
public class Uczniowie {
 private Integer id;
 private String imie;
 private String nazwisko;
 private String uwagi;
 private Integer klasa;
 private Integer rok;
 
 public Uczniowie() {
 }
 
 public Uczniowie(Integer id, String imie, String nazwisko, String uwagi, Integer klasa, Integer rok) {
     this.id = id;
     this.imie = imie;
     this.nazwisko = nazwisko;
     this.uwagi = uwagi;
     this.klasa = klasa;
     this.rok = rok;
 }
 
 @Id
 @Column(name = "ID")
 public Integer getId() {
     return id;
 }
 
// public void setId(Integer id) {
//     this.id = id;
// }
 
 @Column(name = "Imie", nullable = false)
 public String getImie() {
     return imie;
 }
 
// public void setImie(String imie) {
//     this.imie = imie;
// }
 
 @Column(name = "Nazwisko", nullable = false)
 public String getNazwisko() {
     return nazwisko;
 }
 
// public void setNazwisko(String nazwisko) {
//     this.nazwisko = nazwisko; }
     
     @Column(name = "Uwagi")
     public String getUwagi() {
         return uwagi;
     }
     
//     public void setUwagi(String uwagi) {
//         this.uwagi = uwagi;
//     }
     
     @Column(name = "Klasa", nullable = false)
     public Integer getKlasa() {
         return klasa;
     }
     
//     public void setKlasa(Integer klasa) {
//         this.klasa = klasa;
//     }
     
     @Column(name = "Rok", nullable = false)
     public Integer getRok() {
         return rok;
     }
     
//     public void setRok(Integer rok) {
//         this.rok = rok;
//     
//     
// }
}