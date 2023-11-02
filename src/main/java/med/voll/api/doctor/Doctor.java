package med.voll.api.doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Adress;

@Table(name = "doctor")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String name;
   private String email;
   private String crm;

   @Enumerated(EnumType.STRING)
   private Speciality speciality;

   @Embedded
   private Adress adress;

    public Doctor(MedicalRegisterData data) {

         this.name = data.name();
         this.email = data.email();
         this.crm = data.crm();
         this.speciality = data.speciality();
         this.adress = new Adress(data.addressDate());
    }
}
