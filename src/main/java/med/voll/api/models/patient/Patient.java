package med.voll.api.models.patient;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.models.address.Adress;

@Table(name = "patient")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String cpf;
    @Embedded
    private Adress adress;
    private Boolean active;

    public Patient(PatientRegisterData data) {
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.cpf = data.cpf();
        this.adress = new Adress(data.addressDate());
        this.active = true;
    }

    public void updateInformations(PatientUpdateData data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.telephone() != null) {
            this.telephone = data.telephone();
        }
        if (data.addressDate() != null) {
            this.adress.updateInformation(data.addressDate());
        }

    }

    public void setInactive() {
        this.active = false;
    }
}
