package med.voll.api.doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Adress;

import javax.swing.text.StyledEditorKit;

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
   private String telephone;
   private String crm;

   @Enumerated(EnumType.STRING)
   private Speciality speciality;

   @Embedded
   private Adress adress;

   private boolean active;

    public Doctor(MedicalRegisterData data) {
         this.active = true;
         this.name = data.name();
         this.email = data.email();
         this.telephone = data.telephone();
         this.crm = data.crm();
         this.speciality = data.speciality();
         this.adress = new Adress(data.addressDate());
    }

    public void updateInformation(MedicalUpdateData data) {
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.telephone() != null){
            this.telephone = data.telephone();
        }
        if (data.addressDate() != null){
            this.adress.updateInformation(data.addressDate());
        }

    }

    public void setInactive() {
        this.active = false;
    }
}
