package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Adress {
    private String street;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String uf;
    private String number;
    private String complement;

    public Adress(AddressDate data) {
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.zipCode = data.zipCode();
        this.city = data.city();
        this.uf = data.uf();
        this.number = data.number();
        this.complement = data.complement();
    }

    public void updateInformation(AddressDate addressDate) {
        if (addressDate.street() != null) {
            this.street = addressDate.street();
        }
        if (addressDate.neighborhood() != null) {
            this.neighborhood = addressDate.neighborhood();
        }
        if (addressDate.zipCode() != null) {
            this.zipCode = addressDate.zipCode();
        }
        if (addressDate.city() != null) {
            this.city = addressDate.city();
        }
        if (addressDate.uf() != null) {
            this.uf = addressDate.uf();
        }
        if (addressDate.number() != null) {
            this.number = addressDate.number();
        }
        if (addressDate.complement() != null) {
            this.complement = addressDate.complement();
        }

    }
}
