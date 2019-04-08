package polaczenie;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "Klasy")
public class Klasy {
 private Integer id;
 private String uwagi;
 private Integer liczba_uczniow;
 private Integer rok;
 
 public Klasy() {
 }
 
 public Klasy(Integer id, String uwagi, Integer liczba_uczniow, Integer rok) {
     this.id = id;
     this.uwagi = uwagi;
     this.liczba_uczniow = liczba_uczniow;
     this.rok = rok;
 }
 
 @Id
 @Column(name = "ID")
 public Integer getId() {
     return id;
 }
 
 public void setId(Integer id) {
     this.id = id;
 }
 
     @Column(name = "Uwagi")
     public String getUwagi() {
         return uwagi;
     }
     
     public void setUwagi(String uwagi) {
         this.uwagi = uwagi;
     }
     
     @Column(name = "Liczba_uczniow", nullable = false)
     public Integer getLiczba_uczniow() {
         return liczba_uczniow;
     }
     
     public void setLiczba_uczniow(Integer liczba_uczniow) {
         this.liczba_uczniow = liczba_uczniow;
     }
     
     @Column(name = "Rok", nullable = false)
     public Integer getRok() {
         return rok;
     }
     
     public void setRok(Integer rok) {
         this.rok = rok;
     
     
 }
}